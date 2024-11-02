create table autuacao (
	id BIGSERIAL not null,
    veiculo_id bigint not null,
    descricao text not null,
    valor_multa decimal(10, 2) not null,
    data_ocorrencia TIMESTAMP not null,

    primary key (id)
);

alter table autuacao add constraint fk_autuacao_veiculo
foreign key (veiculo_id) references veiculo (id);