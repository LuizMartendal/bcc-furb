from sqlalchemy import Integer, Column, String, Boolean, DateTime

from infra.database import Base


class UserSession(Base):
    __tablename__ = "sessions"
    id = Column(Integer, primary_key=True, index=True)
    username = Column(String, unique=False, index=True)
    current_session_token = Column(String, nullable=True)
    current_session_mfa = Column(String, nullable=True)
    used = Column(Boolean, nullable=False, default=False)
    expiration_time = Column(DateTime, nullable=False)
