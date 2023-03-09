-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-08-30 23:57:34.54

-- tables
-- Table: candidato
CREATE TABLE candidato (
    nr_candidato int NOT NULL,
    nm_candidato varchar(50) NOT NULL,
    nm_fantasia varchar(50) NOT NULL,
    partido_nr_partido int NOT NULL,
    cargo_cd_cargo int NOT NULL,
    CONSTRAINT candidato_pk PRIMARY KEY (nr_candidato)
);

-- Table: cargo
CREATE TABLE cargo (
    cd_cargo int NOT NULL,
    ds_cargo varchar(30) NOT NULL,
    CONSTRAINT cargo_pk PRIMARY KEY (cd_cargo)
);

-- Table: eleitor
CREATE TABLE eleitor (
    nr_titulo int NOT NULL,
    nm_eleitor varchar(50) NOT NULL,
    ds_logradouro varchar(50) NOT NULL,
    ds_complemento varchar(30) NOT NULL,
    nm_bairro varchar(50) NOT NULL,
    nr_cep char(8) NOT NULL,
    nm_municipio varchar(50) NOT NULL,
    sg_uf char(2) NOT NULL,
    dt_nascimento date NOT NULL,
    ds_escolaridade varchar(50) NOT NULL,
    ds_email varchar(50) NOT NULL,
    secao_nr_secao int NOT NULL,
    CONSTRAINT eleitor_pk PRIMARY KEY (nr_titulo)
);

-- Table: partido
CREATE TABLE partido (
    nr_partido int NOT NULL,
    nm_partido varchar(50) NOT NULL,
    sg_partido varchar(50) NOT NULL,
    CONSTRAINT partido_pk PRIMARY KEY (nr_partido)
);

-- Table: secao
CREATE TABLE secao (
    nr_secao int NOT NULL,
    nm_secao varchar(50) NOT NULL,
    ds_logradouro varchar(50) NOT NULL,
    ds_complemento varchar(50) NOT NULL,
    nm_bairro varchar(50) NOT NULL,
    nr_cep char(8) NOT NULL,
    nm_municipio varchar(50) NOT NULL,
    sg_uf char(2) NOT NULL,
    zona_eleitoral_nr_zona_eleitoral int NOT NULL,
    CONSTRAINT secao_pk PRIMARY KEY (nr_secao)
);

-- Table: urna
CREATE TABLE urna (
    nr_urna int NOT NULL,
    nm_modelo varchar(50) NOT NULL,
    tp_urna char(1) NOT NULL,
    secao_nr_secao int NOT NULL,
    CONSTRAINT urna_pk PRIMARY KEY (nr_urna)
);

-- Table: voto
CREATE TABLE voto (
    dt_registro date NOT NULL,
    hr_registro time NOT NULL,
    tp_voto char(1) NOT NULL,
    urna_nr_urna int NOT NULL,
    cargo_cd_cargo int NOT NULL,
    candidato_nr_candidato int NOT NULL
);

-- Table: zona_eleitoral
CREATE TABLE zona_eleitoral (
    nr_zona_eleitoral int NOT NULL,
    nm_zona_eleitoral varchar(50) NOT NULL,
    sg_uf char(2) NOT NULL,
    CONSTRAINT zona_eleitoral_pk PRIMARY KEY (nr_zona_eleitoral)
);

-- foreign keys
-- Reference: candidato_cargo (table: candidato)
ALTER TABLE candidato ADD CONSTRAINT candidato_cargo FOREIGN KEY candidato_cargo (cargo_cd_cargo)
    REFERENCES cargo (cd_cargo);

-- Reference: candidato_partido (table: candidato)
ALTER TABLE candidato ADD CONSTRAINT candidato_partido FOREIGN KEY candidato_partido (partido_nr_partido)
    REFERENCES partido (nr_partido);

-- Reference: eleitor_secao (table: eleitor)
ALTER TABLE eleitor ADD CONSTRAINT eleitor_secao FOREIGN KEY eleitor_secao (secao_nr_secao)
    REFERENCES secao (nr_secao);

-- Reference: secao_zona_eleitoral (table: secao)
ALTER TABLE secao ADD CONSTRAINT secao_zona_eleitoral FOREIGN KEY secao_zona_eleitoral (zona_eleitoral_nr_zona_eleitoral)
    REFERENCES zona_eleitoral (nr_zona_eleitoral);

-- Reference: urna_secao (table: urna)
ALTER TABLE urna ADD CONSTRAINT urna_secao FOREIGN KEY urna_secao (secao_nr_secao)
    REFERENCES secao (nr_secao);

-- Reference: voto_candidato (table: voto)
ALTER TABLE voto ADD CONSTRAINT voto_candidato FOREIGN KEY voto_candidato (candidato_nr_candidato)
    REFERENCES candidato (nr_candidato);

-- Reference: voto_cargo (table: voto)
ALTER TABLE voto ADD CONSTRAINT voto_cargo FOREIGN KEY voto_cargo (cargo_cd_cargo)
    REFERENCES cargo (cd_cargo);

-- Reference: voto_urna (table: voto)
ALTER TABLE voto ADD CONSTRAINT voto_urna FOREIGN KEY voto_urna (urna_nr_urna)
    REFERENCES urna (nr_urna);

-- End of file.

