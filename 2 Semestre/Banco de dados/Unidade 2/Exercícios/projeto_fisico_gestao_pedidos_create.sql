-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-06 22:57:21.095

-- tables
-- Table: categoria
CREATE TABLE categoria (
    cd_categoria int NOT NULL,
    nm_categoria Varchar(50) NOT NULL,
    CONSTRAINT categoria_pk PRIMARY KEY (cd_categoria)
);

-- Table: cliente
CREATE TABLE cliente (
    cd_cliente int NOT NULL,
    nm_cliente Varchar(50) NOT NULL,
    nr_telefone varchar(20) NOT NULL,
    ds_email Varchar(50) NOT NULL,
    vl_limite_credito decimal(8,2) NOT NULL,
    CONSTRAINT cliente_pk PRIMARY KEY (cd_cliente)
);

-- Table: endereco
CREATE TABLE endereco (
    cd_endereco int NOT NULL,
    nm_logradouro Varchar(50) NOT NULL,
    ds_complemento Varchar(20) NOT NULL,
    nm_bairro Varchar(30) NOT NULL,
    nr_cep char(8) NOT NULL,
    municipio_cd_municipio int NOT NULL,
    cliente_cd_cliente int NOT NULL,
    CONSTRAINT endereco_pk PRIMARY KEY (cd_endereco)
);

-- Table: item_pedido
CREATE TABLE item_pedido (
    cd_produto int NOT NULL,
    nr_pedido int NOT NULL,
    vl_produto decimal(8,2) NOT NULL,
    qtd_produto int NOT NULL,
    vl_total decimal(8,2) NOT NULL,
    CONSTRAINT item_pedido_pk PRIMARY KEY (cd_produto,nr_pedido)
);

-- Table: municipio
CREATE TABLE municipio (
    cd_municipio int NOT NULL,
    nm_municipio Varchar(50) NOT NULL,
    sg_uf char(2) NOT NULL,
    CONSTRAINT municipio_pk PRIMARY KEY (cd_municipio)
);

-- Table: pedido
CREATE TABLE pedido (
    nr_pedido int NOT NULL,
    dt_emissao decimal(8,2) NOT NULL,
    cd_cliente int NOT NULL,
    CONSTRAINT pedido_pk PRIMARY KEY (nr_pedido)
);

-- Table: produto
CREATE TABLE produto (
    cd_produto int NOT NULL,
    nm_produto Varchar(50) NOT NULL,
    qt_estoque int NOT NULL,
    vl_produto decimal(8,2) NOT NULL,
    categoria_cd_categoria int NOT NULL,
    CONSTRAINT produto_pk PRIMARY KEY (cd_produto)
);

-- foreign keys
-- Reference: Table_7_pedido (table: item_pedido)
ALTER TABLE item_pedido ADD CONSTRAINT Table_7_pedido FOREIGN KEY Table_7_pedido (nr_pedido)
    REFERENCES pedido (nr_pedido);

-- Reference: Table_7_produto (table: item_pedido)
ALTER TABLE item_pedido ADD CONSTRAINT Table_7_produto FOREIGN KEY Table_7_produto (cd_produto)
    REFERENCES produto (cd_produto);

-- Reference: endereco_cliente (table: endereco)
ALTER TABLE endereco ADD CONSTRAINT endereco_cliente FOREIGN KEY endereco_cliente (cliente_cd_cliente)
    REFERENCES cliente (cd_cliente);

-- Reference: endereco_municipio (table: endereco)
ALTER TABLE endereco ADD CONSTRAINT endereco_municipio FOREIGN KEY endereco_municipio (municipio_cd_municipio)
    REFERENCES municipio (cd_municipio);

-- Reference: pedido_cliente (table: pedido)
ALTER TABLE pedido ADD CONSTRAINT pedido_cliente FOREIGN KEY pedido_cliente (cd_cliente)
    REFERENCES cliente (cd_cliente);

-- Reference: produto_categoria (table: produto)
ALTER TABLE produto ADD CONSTRAINT produto_categoria FOREIGN KEY produto_categoria (categoria_cd_categoria)
    REFERENCES categoria (cd_categoria);

-- End of file.

