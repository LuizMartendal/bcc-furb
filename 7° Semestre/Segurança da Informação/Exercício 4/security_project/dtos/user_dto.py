from pydantic import BaseModel


class UserDTO(BaseModel):
    username: str
    password: str
    email: str
