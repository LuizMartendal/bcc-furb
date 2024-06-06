FROM postgres:14

RUN apt-get update && apt-get install -y \
    postgresql-server-dev-14 \
    build-essential \
    wget \
    && rm -rf /var/lib/apt/lists/*

RUN wget https://github.com/pgvector/pgvector/archive/refs/tags/v0.4.2.tar.gz \
    && tar -xzf v0.4.2.tar.gz \
    && cd pgvector-0.4.2 \
    && make \
    && make install \
    && cd .. \
    && rm -rf pgvector-0.4.2 v0.4.2.tar.gz

COPY init_db.sh /docker-entrypoint-initdb.d/
