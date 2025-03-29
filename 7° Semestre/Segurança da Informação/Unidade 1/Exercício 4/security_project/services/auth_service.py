import uuid
from datetime import datetime, timedelta

from fastapi import HTTPException, Depends
from sqlalchemy.exc import SQLAlchemyError
from sqlalchemy.orm import Session
from starlette import status

from infra import database
from models.user import User
from models.user_session import UserSession
from services import session_service, email_service, user_service, security_service
from services.security_service import pwd_context
from services.session_service import get_session_by_token_and_mfa


def login(username: str, password: str, db: Session = Depends(database.get_db)):
    try:
        user = user_service.get_user(username, db)

        login_validation(user, username, password, db)

        user.failed_attempts = 0

        user_session = session_service.create_session(username, db)

        email_service.send_mfa_token_to_email(user.email, user_session.current_session_mfa)

        db.commit()
        db.refresh(user)

        print(f"INFO: primeira etapa da autenticação finalizada com sucesso")
        return user_session.current_session_token
    except SQLAlchemyError:
        db.rollback()
        raise


def login_mfa(token, mfa_token, db: Session = Depends(database.get_db)):
    print(f"INFO: buscando usuário pelos códigos de autenticação")
    user_session: UserSession = get_session_by_token_and_mfa(token, mfa_token, db)

    if not user_session:
        print(f"ERROR: usuário não encontrado para os códigos de autenticação fornecidos")
        raise HTTPException(status_code=status.HTTP_401_UNAUTHORIZED, detail="Credenciais inválidas")

    if datetime.now() > user_session.expiration_time or user_session.used:
        print(f"ERROR: credenciais expiradas")
        raise HTTPException(status_code=status.HTTP_401_UNAUTHORIZED, detail="Credenciais expiradas")

    access_token_expires = timedelta(minutes=30)
    access_token = security_service.create_access_token(
        data={"sub": user_session.username}, expires_delta=access_token_expires
    )

    session_service.set_session_as_used(user_session, db)

    print(f"INFO: usuário {user_session.username} autenticado com sucesso")
    return {"access_token": access_token, "token_type": "bearer"}


def login_validation(user, username, password, db):
    if not user:
        print(f"INFO: usuário {username} não encontrado")
        raise HTTPException(status_code=status.HTTP_401_UNAUTHORIZED,
                            detail="Credenciais inválidas")

    if user.lockout_time is not None and user.lockout_time > datetime.utcnow():
        print(f"INFO: autenticação falhou, usuário {username} está bloqueado")
        raise HTTPException(status_code=status.HTTP_403_FORBIDDEN,
                            detail="Conta bloqueada. Tente novamente mais tarde.")

    if user.password != password:
        print(f"INFO: credenciais do usuário {username} inválidas")
        user.failed_attempts += 1
        if user.failed_attempts >= 3:
            user.lockout_time = datetime.utcnow() + timedelta(minutes=5)
        db.commit()
        db.refresh(user)
        raise HTTPException(status_code=status.HTTP_401_UNAUTHORIZED, detail="Credenciais inválidas.")


def verify_password(plain_password, hashed_password):
    return pwd_context.verify(plain_password, hashed_password)


def get_password_hash(password):
    return pwd_context.hash(password)
