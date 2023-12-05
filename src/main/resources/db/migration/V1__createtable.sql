CREATE TABLE funcionarios (
    id BIGINT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    varinha VARCHAR(100) NOT NULL,
    patrono VARCHAR(100),
    transformacao VARCHAR(100),
    materia VARCHAR(100),
    cargo VARCHAR(100) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    complemento VARCHAR(100),
    pais VARCHAR(20) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    primary key (id)
);

CREATE TABLE alunos (
    id BIGINT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    varinha VARCHAR(100) NOT NULL,
    patrono VARCHAR(100),
    status VARCHAR(100) NOT NULL,
    casa VARCHAR(100) NOT NULL,
    mascote varchar(20) NOT NULL,
    ano INT NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    complemento VARCHAR(100),
    pais VARCHAR(20) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    primary key (id)
);