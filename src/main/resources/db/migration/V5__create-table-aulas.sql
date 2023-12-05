create table aulas (
    id bigint not null auto_increment,
    funcionario_id bigint not null,
    aluno_id bigint not null,
    data datetime not null,
    primary key (id),
    constraint fk_aulas_funcionario_id foreign key (funcionario_id) references funcionarios (id),
    constraint fk_aulas_aluno_id foreign key (aluno_id) references alunos (id)
);