create table proprietario (
    id BIGSERIAL not null,
    nome varchar(60) not null,
    cpf varchar(11) not null,
    data_nascimento date not null,
    endereco_cep varchar(9) not null,
    endereco_rua varchar(100) not null,
    endereco_numero varchar(20) not null,
    endereco_bairro varchar(60) not null,
    endereco_estado varchar(2) not null,
    endereco_complemento varchar(60) not null,
    email varchar(255) not null,
    telefone varchar(20) not null,

    primary key (id)
);

alter table proprietario
add constraint uk_proprietario unique (email);