from pydantic import BaseModel


class BaseAuthenticationDTO(BaseModel):
    username: str
    password: str
