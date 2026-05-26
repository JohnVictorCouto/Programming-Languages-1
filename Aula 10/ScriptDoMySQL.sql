-- 1. Criação do Banco de Dados
CREATE DATABASE IF NOT EXISTS academia;
USE academia;

-- 2. Limpeza de tabelas
DROP TABLE IF EXISTS disciplina_professor;
DROP TABLE IF EXISTS disciplina;
DROP TABLE IF EXISTS professor;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS conta_corrente;
DROP TABLE IF EXISTS agencia;

-- 3. Tabelas Acadêmicas
CREATE TABLE professor (
  matricula INT NOT NULL,
  nome VARCHAR(100) NOT NULL,
  idade INT,
  PRIMARY KEY (matricula)
) ENGINE = InnoDB;

CREATE TABLE disciplina (
  codigo VARCHAR(10) NOT NULL,
  nome VARCHAR(100) NOT NULL,
  PRIMARY KEY (codigo)
) ENGINE = InnoDB;

CREATE TABLE disciplina_professor (
    codigo_disciplina VARCHAR(10) NOT NULL,
    matricula_professor INT NOT NULL,

    PRIMARY KEY (codigo_disciplina, matricula_professor),

    FOREIGN KEY (codigo_disciplina)
        REFERENCES disciplina(codigo)
        ON DELETE CASCADE,

    FOREIGN KEY (matricula_professor)
        REFERENCES professor(matricula)
        ON DELETE CASCADE
) ENGINE = InnoDB;

-- 4. Tabelas Bancárias

-- Agencia: numero (pk), digito
CREATE TABLE agencia (
  numero INT NOT NULL,
  digito INT NOT NULL,
  PRIMARY KEY (numero)
) ENGINE = InnoDB;

-- Conta Corrente: numero (pk), digito
CREATE TABLE conta_corrente (
  numero INT NOT NULL,
  digito INT NOT NULL,
  PRIMARY KEY (numero)
) ENGINE = InnoDB;

-- Cliente: cpf (pk), nome
CREATE TABLE cliente (
  cpf VARCHAR(14) NOT NULL,
  nome VARCHAR(100) NOT NULL,
  PRIMARY KEY (cpf)
) ENGINE = InnoDB;

-- Configurações e Verificações
SET autocommit = 0;

DESCRIBE professor;
DESCRIBE disciplina;
DESCRIBE agencia;
DESCRIBE conta_corrente;
DESCRIBE cliente;