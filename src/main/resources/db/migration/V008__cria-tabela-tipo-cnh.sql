create table tipo_cnh (
	id bigint not null auto_increment,
    tipo varchar(20) not null,

    primary key (id)
);

INSERT INTO tipo_cnh(id, tipo) VALUES (1, 'PERMISSAO');
INSERT INTO tipo_cnh(id, tipo) VALUES (2, 'DEFINITIVA');