-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-08-30 21:58:02.465

-- tables
-- Table: Aluno
CREATE TABLE Aluno (
    cd_aluno int NOT NULL,
    nm_aluno varchar(50) NOT NULL,
    ds_email varchar(50) NOT NULL,
    CONSTRAINT Aluno_pk PRIMARY KEY (cd_aluno)
);

-- Table: Aluno_Turma
CREATE TABLE Aluno_Turma (
    cd_aluno int NOT NULL,
    cd_turma int NOT NULL,
    CONSTRAINT Aluno_Turma_pk PRIMARY KEY (cd_aluno,cd_turma)
);

-- Table: Area
CREATE TABLE Area (
    cd_area int NOT NULL,
    ds_area varchar(50) NOT NULL,
    CONSTRAINT Area_pk PRIMARY KEY (cd_area)
);

-- Table: Curso
CREATE TABLE Curso (
    cd_curso int NOT NULL,
    nm_curso varchar(50) NOT NULL,
    nr_horas int NOT NULL,
    cd_area int NOT NULL,
    cd_professortribute_1 int NOT NULL,
    CONSTRAINT Curso_pk PRIMARY KEY (cd_curso)
);

-- Table: Curso_Aluno
CREATE TABLE Curso_Aluno (
    cd_curso int NOT NULL,
    cd_aluno int NOT NULL,
    CONSTRAINT Curso_Aluno_pk PRIMARY KEY (cd_curso,cd_aluno)
);

-- Table: Curso_Disciplina
CREATE TABLE Curso_Disciplina (
    cd_curso int NOT NULL,
    cd_disciplina int NOT NULL,
    CONSTRAINT Curso_Disciplina_pk PRIMARY KEY (cd_curso,cd_disciplina)
);

-- Table: Disciplina
CREATE TABLE Disciplina (
    cd_disciplina int NOT NULL,
    nm_disciplina varchar(50) NOT NULL,
    ds_objetivos varchar(100) NOT NULL,
    ds_conteudos varchar(200) NOT NULL,
    nr_horas int NOT NULL,
    CONSTRAINT Disciplina_pk PRIMARY KEY (cd_disciplina)
);

-- Table: Professor
CREATE TABLE Professor (
    cd_professortribute_1 int NOT NULL,
    nm_professor varchar(50) NOT NULL,
    ds_email varchar(50) NOT NULL,
    cd_area int NOT NULL,
    CONSTRAINT Professor_pk PRIMARY KEY (cd_professortribute_1)
);

-- Table: Turma
CREATE TABLE Turma (
    cd_turma int NOT NULL,
    dt_inicio date NOT NULL,
    dt_termino date NOT NULL,
    fl_turno char(1) NOT NULL,
    cd_disciplina int NOT NULL,
    cd_professortribute_1 int NOT NULL,
    CONSTRAINT Turma_pk PRIMARY KEY (cd_turma)
);

-- foreign keys
-- Reference: Aluno_Turma_Aluno (table: Aluno_Turma)
ALTER TABLE Aluno_Turma ADD CONSTRAINT Aluno_Turma_Aluno FOREIGN KEY Aluno_Turma_Aluno (cd_aluno)
    REFERENCES Aluno (cd_aluno);

-- Reference: Aluno_Turma_Turma (table: Aluno_Turma)
ALTER TABLE Aluno_Turma ADD CONSTRAINT Aluno_Turma_Turma FOREIGN KEY Aluno_Turma_Turma (cd_turma)
    REFERENCES Turma (cd_turma);

-- Reference: Curso_Aluno_Aluno (table: Curso_Aluno)
ALTER TABLE Curso_Aluno ADD CONSTRAINT Curso_Aluno_Aluno FOREIGN KEY Curso_Aluno_Aluno (cd_aluno)
    REFERENCES Aluno (cd_aluno);

-- Reference: Curso_Aluno_Curso (table: Curso_Aluno)
ALTER TABLE Curso_Aluno ADD CONSTRAINT Curso_Aluno_Curso FOREIGN KEY Curso_Aluno_Curso (cd_curso)
    REFERENCES Curso (cd_curso);

-- Reference: Curso_Area (table: Curso)
ALTER TABLE Curso ADD CONSTRAINT Curso_Area FOREIGN KEY Curso_Area (cd_area)
    REFERENCES Area (cd_area);

-- Reference: Curso_Disciplina_Curso (table: Curso_Disciplina)
ALTER TABLE Curso_Disciplina ADD CONSTRAINT Curso_Disciplina_Curso FOREIGN KEY Curso_Disciplina_Curso (cd_curso)
    REFERENCES Curso (cd_curso);

-- Reference: Curso_Disciplina_Disciplina (table: Curso_Disciplina)
ALTER TABLE Curso_Disciplina ADD CONSTRAINT Curso_Disciplina_Disciplina FOREIGN KEY Curso_Disciplina_Disciplina (cd_disciplina)
    REFERENCES Disciplina (cd_disciplina);

-- Reference: Curso_Professor (table: Curso)
ALTER TABLE Curso ADD CONSTRAINT Curso_Professor FOREIGN KEY Curso_Professor (cd_professortribute_1)
    REFERENCES Professor (cd_professortribute_1);

-- Reference: Professor_Area (table: Professor)
ALTER TABLE Professor ADD CONSTRAINT Professor_Area FOREIGN KEY Professor_Area (cd_area)
    REFERENCES Area (cd_area);

-- Reference: Turma_Disciplina (table: Turma)
ALTER TABLE Turma ADD CONSTRAINT Turma_Disciplina FOREIGN KEY Turma_Disciplina (cd_disciplina)
    REFERENCES Disciplina (cd_disciplina);

-- Reference: Turma_Professor (table: Turma)
ALTER TABLE Turma ADD CONSTRAINT Turma_Professor FOREIGN KEY Turma_Professor (cd_professortribute_1)
    REFERENCES Professor (cd_professortribute_1);

-- End of file.

