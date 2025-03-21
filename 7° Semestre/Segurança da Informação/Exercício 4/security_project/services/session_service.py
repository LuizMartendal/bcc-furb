import datetime
import uuid

from fastapi import HTTPException
from fastapi.params import Depends
from sqlalchemy import and_
from sqlalchemy.exc import SQLAlchemyError
from sqlalchemy.orm import Session
from starlette import status

from infra.database import get_db
from models.user_session import UserSession


def get_session_by_token_and_mfa(token, mfa_token, db: Session = Depends(get_db)):
    criteria = and_(UserSession.current_session_token == token, UserSession.current_session_mfa == mfa_token)
    return db.query(UserSession) \
        .filter(criteria) \
        .first()


def create_session(username, db: Session):
    session = UserSession()
    session.username = username
    session.current_session_token = str(uuid.uuid4())
    session.current_session_mfa = str(uuid.uuid4())
    session.used = False
    session.expiration_time = datetime.datetime.now() + datetime.timedelta(hours=2)

    return save_session(session, db)


def save_session(session: UserSession, db: Session = Depends(get_db)):
    try:
        db.add(session)
        db.commit()
        db.refresh(session)
        return session
    except SQLAlchemyError:
        db.rollback()
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST,
                            detail="Erro ao criar seção, tente novamente mais tarde")


def set_session_as_used(session: UserSession, db: Session = Depends(get_db)):
    session.used = True
    db.merge(session)
    db.commit()
    return
