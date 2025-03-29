from pydantic import BaseModel


class MFAAuthenticationDTO(BaseModel):
    token: str
    mfa_token: str
