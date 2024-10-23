# Use uma imagem oficial do Apache Derby
FROM az82/docker-derby

# Definindo variáveis de ambiente
ENV DERBY_DB_DIR=/dbs/BrRobotics

# Criar o diretório para o banco de dados
RUN mkdir -p $DERBY_DB_DIR

# Copiar o script de inicialização
COPY init.sh /docker-entrypoint-initdb.d/init.sh

# Dar permissão de execução ao script
RUN chmod +x /docker-entrypoint-initdb.d/init.sh

# Comando padrão para iniciar o servidor Derby
CMD ["java", "-jar", "/derby/lib/derbyrun.jar", "server", "start"]
