from fastapi import FastAPI

from infra.database import Base, engine
from routes import user_routes, auth_routes

# uvicorn servico:app --host localhost --port 8000 --reload
app = FastAPI()

app.include_router(user_routes.router, prefix="/users", tags=["users"])
app.include_router(auth_routes.router, prefix="/auth", tags=["auth"])

from models import *

Base.metadata.create_all(bind=engine)


@app.get("/")
def read_root():
    return {"message": "Bem-vindo à API FastAPI!"}
