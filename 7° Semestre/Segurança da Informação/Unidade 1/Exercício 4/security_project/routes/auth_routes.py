from fastapi import APIRouter, Depends
from sqlalchemy.orm import Session

from dtos.base_authentication_dto import BaseAuthenticationDTO
from dtos.mfa_athentication_dto import MFAAuthenticationDTO
from infra.database import get_db
from services import auth_service

router = APIRouter()


@router.post("/login-mfa/")
def login_mfa(credentials: MFAAuthenticationDTO, db: Session = Depends(get_db)):
    print(f"INFO: autenticando usuário por MFA")
    return auth_service.login_mfa(credentials.token, credentials.mfa_token, db)


@router.post("/login/")
def login(credentials: BaseAuthenticationDTO, db: Session = Depends(get_db)):
    print(f"INFO: usuário {credentials.username} está tentando autenticar")
    return auth_service.login(credentials.username, credentials.password, db)
