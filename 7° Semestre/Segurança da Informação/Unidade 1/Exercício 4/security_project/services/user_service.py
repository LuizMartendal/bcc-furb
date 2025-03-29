import jwt
from fastapi import HTTPException, Depends
from sqlalchemy.exc import SQLAlchemyError
from sqlalchemy.orm import Session
from starlette import status

from dtos.user_dto import UserDTO
from infra.database import get_db
from models.user import User
from services.security_service import SECRET_KEY, ALGORITHM


def register_user(user: UserDTO, db: Session):
    user = User(username=user.username, email=user.email, password=user.password)
    user.failed_attempts = 0
    save_user(user, db)


def save_user(user, db: Session):
    try:
        db.add(user)
        db.commit()
        db.refresh(user)
    except SQLAlchemyError as e:
        db.rollback()
        print(e)
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST,
                            detail="Não foi possível criar seu usuário. Tente novamente mais tarde")


def get_user(username: str, db: Session = Depends(get_db)):
    return db.query(User).filter(User.username == username).first()


def get_current_user(token: str, db: Session = Depends(get_db)):
    exception = HTTPException(
        status_code=status.HTTP_401_UNAUTHORIZED,
        detail="Credenciais inválidas"
    )
    try:
        payload = jwt.decode(token.split("Bearer ")[1], SECRET_KEY, algorithms=[ALGORITHM])
        username: str = payload.get("sub")
        if username is None:
            raise exception
        return get_user(username, db)
    except Exception:
        raise exception
