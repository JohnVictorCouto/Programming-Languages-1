CREATE DATABASE IF NOT EXISTS db_materia;
USE db_materia;

DROP TABLE IF EXISTS tabela_notas;
DROP TABLE IF EXISTS login_senha;

CREATE TABLE login_senha (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL
);

CREATE TABLE tabela_notas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    login_id INT NOT NULL,

    materia_1 VARCHAR(50) NOT NULL,
    p1_1 DECIMAL(10,2) DEFAULT 0,
    p2_1 DECIMAL(10,2) DEFAULT 0,
    t1_1 DECIMAL(10,2) DEFAULT 0,
    p3_1 DECIMAL(10,2) DEFAULT 0,
    p4_1 DECIMAL(10,2) DEFAULT 0,
    t2_1 DECIMAL(10,2) DEFAULT 0,
    faltas_1 INT DEFAULT 0,

    materia_2 VARCHAR(50) NOT NULL,
    p1_2 DECIMAL(10,2) DEFAULT 0,
    p2_2 DECIMAL(10,2) DEFAULT 0,
    t1_2 DECIMAL(10,2) DEFAULT 0,
    p3_2 DECIMAL(10,2) DEFAULT 0,
    p4_2 DECIMAL(10,2) DEFAULT 0,
    t2_2 DECIMAL(10,2) DEFAULT 0,
    faltas_2 INT DEFAULT 0,

    materia_3 VARCHAR(50) NOT NULL,
    p1_3 DECIMAL(10,2) DEFAULT 0,
    p2_3 DECIMAL(10,2) DEFAULT 0,
    t1_3 DECIMAL(10,2) DEFAULT 0,
    p3_3 DECIMAL(10,2) DEFAULT 0,
    p4_3 DECIMAL(10,2) DEFAULT 0,
    t2_3 DECIMAL(10,2) DEFAULT 0,
    faltas_3 INT DEFAULT 0,

    materia_4 VARCHAR(50) NOT NULL,
    p1_4 DECIMAL(10,2) DEFAULT 0,
    p2_4 DECIMAL(10,2) DEFAULT 0,
    t1_4 DECIMAL(10,2) DEFAULT 0,
    p3_4 DECIMAL(10,2) DEFAULT 0,
    p4_4 DECIMAL(10,2) DEFAULT 0,
    t2_4 DECIMAL(10,2) DEFAULT 0,
    faltas_4 INT DEFAULT 0,

    ultima_alteracao DATETIME NULL,

    CONSTRAINT fk_tabela_notas_login
        FOREIGN KEY (login_id) REFERENCES login_senha(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT uq_tabela_notas_login UNIQUE (login_id)
);

INSERT INTO login_senha (usuario, senha)
VALUES ('admin', '12345');

INSERT INTO tabela_notas
(login_id,
 materia_1, materia_2, materia_3, materia_4)
VALUES
(1, 'Programação', 'Banco de Dados', 'Engenharia de Software', 'Matemática');