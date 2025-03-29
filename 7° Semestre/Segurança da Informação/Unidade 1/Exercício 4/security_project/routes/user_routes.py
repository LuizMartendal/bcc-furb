from fastapi import APIRouter, Depends
from fastapi.security import OAuth2PasswordBearer
from sqlalchemy.orm import Session
from starlette.requests import Request

from dtos.user_dto import UserDTO
from infra.database import get_db
from services import user_service

router = APIRouter()


@router.post("/register/")
def register_user(user: UserDTO, db: Session = Depends(get_db)):
    user_service.register_user(user, db)
    return {"message": "Usuário registrado com sucesso!"}


@router.get("/current-user/")
def get_current_user(request: Request, db: Session = Depends(get_db)):
    token = request.headers.get("Authorization")
    return user_service.get_current_user(token, db)
