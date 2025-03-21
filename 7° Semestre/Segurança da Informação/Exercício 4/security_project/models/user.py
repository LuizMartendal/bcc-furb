from sqlalchemy import Integer, Column, String, DateTime

from infra.database import Base


class User(Base):
    __tablename__ = "users"
    id = Column(Integer, primary_key=True, index=True)
    username = Column(String, unique=True, index=True)
    password = Column(String)
    email = Column(String)
    failed_attempts = Column(Integer, default=0)
    lockout_time = Column(DateTime, nullable=True)
