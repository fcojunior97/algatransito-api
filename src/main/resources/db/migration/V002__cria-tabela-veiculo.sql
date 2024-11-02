create table veiculo (
	id BIGSERIAL not null,
    proprietario_id bigint not null,
    marca varchar(20) not null,
    modelo varchar(60) not null,
    placa varchar(7) not null,
    renavam varchar(11) not null,
    chassi varchar(17) not null,
    cor varchar(20) not null,
    ano_fabricacao_modelo varchar(15) not null,
    tipo varchar(20) not null,
    combustivel varchar(20) not null,
    categoria varchar(15) not null,
    especie varchar(15) not null,
    nacionalidade varchar(10) not null,
    restricao varchar(12) not null,
    potencia_cilindradas varchar(20) not null,
    capacidade_passageiros varchar(20) not null,
    municipio varchar(20) not null,
    status varchar(20) not null,
    licenciamento varchar(4) not null,
    observacao varchar(255) not null,
    data_cadastro TIMESTAMP  not null,
    data_apreensao TIMESTAMP,

    primary key (id)
);

alter table veiculo add constraint fk_veiculo_proprietario foreign key (proprietario_id) references proprietario (id);

alter table veiculo add constraint uk_veiculo unique (placa);

alter table veiculo add constraint uk_chassi unique (chassi);
