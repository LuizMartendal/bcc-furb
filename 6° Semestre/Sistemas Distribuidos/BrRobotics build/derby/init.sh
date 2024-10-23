#!/bin/bash

DERBY_DATABASE="BrRobotics"
DERBY_USER="root"
DERBY_PASSWORD="root"
DATABASE_PATH="1527/$DERBY_DATABASE"

# Cria o diretório do banco de dados se não existir
mkdir -p /dbs/$DERBY_DATABASE

echo "Criando banco de dados $DERBY_DATABASE"
# Tenta criar o banco de dados
echo "CONNECT 'jdbc:derby://localhost:$DATABASE_PATH;create=true' USER '$DERBY_USER' PASSWORD '$DERBY_PASSWORD';"

# Executa o comando para criar o banco de dados
if ! java -jar /derby/lib/derbyrun.jar ij <<< "CONNECT 'jdbc:derby://localhost:$DATABASE_PATH;create=true' USER '$DERBY_USER' PASSWORD '$DERBY_PASSWORD';"; then
  echo "Erro ao criar o banco de dados."
  exit 1
fi

echo "Banco de dados criado com sucesso"
tail -f /dev/null
