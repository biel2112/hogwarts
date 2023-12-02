CREATE TABLE usuarios(
    id bigint AUTO_INCREMENT,
    login varchar(100) not null,
    senha varchar(100) not null,

    PRIMARY KEY(id)
);