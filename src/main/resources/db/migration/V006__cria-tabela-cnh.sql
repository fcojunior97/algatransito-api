create table cnh (
	id bigint not null auto_increment,
    proprietario_id bigint not null,
    numero_registro varchar(11) not null,
    categoria_cnh varchar(5) not null,
    validade date not null,
    tipo varchar(20) not null,

    primary key (id)
);

alter table cnh add constraint fk_cnh_proprietario foreign key (proprietario_id) references proprietario (id);