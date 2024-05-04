-- criacao e insercao de dados em tabelas

create table Cor_Veiculo (
	id bigint not null auto_increment,
    cor varchar(60) not null,

    primary key (id)
);

INSERT INTO Cor_Veiculo(id, cor) VALUES (1, 'BRANCO');
INSERT INTO Cor_Veiculo(id, cor) VALUES (2, 'PRATA');
INSERT INTO Cor_Veiculo(id, cor) VALUES (3, 'PRETO');
INSERT INTO Cor_Veiculo(id, cor) VALUES (4, 'CINZA');
INSERT INTO Cor_Veiculo(id, cor) VALUES (5, 'VERMELHO');
INSERT INTO Cor_Veiculo(id, cor) VALUES (6, 'AZUL');
INSERT INTO Cor_Veiculo(id, cor) VALUES (7, 'MARROM');
INSERT INTO Cor_Veiculo(id, cor) VALUES (8, 'VERDE');
INSERT INTO Cor_Veiculo(id, cor) VALUES (9, 'AMARELO');

create table Tipo_Veiculo (
	id bigint not null auto_increment,
    tipo varchar(60) not null,

    primary key (id)
);

INSERT INTO Tipo_Veiculo(id, tipo) VALUES (1, 'CICLOMOTOR');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (2, 'MOTONETA');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (3, 'MOTOCICLETA');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (4, 'TRICICLO');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (5, 'QUADRICICLO');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (6, 'AUTOMOVEL');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (7, 'MICROOONIBUS');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (8, 'ONIBUS');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (9, 'REBOQUE');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (10, 'SEMI-REBOQUE');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (11, 'CHRRETE');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (12, 'CAMINHONETE');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (13, 'CAMINHAO');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (14, 'TRATOR');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (15, 'ESPECIAL');
INSERT INTO Tipo_Veiculo(id, tipo) VALUES (16, 'COLECAO');

create table Nacionalidade_Veiculo (
	id bigint not null auto_increment,
    nacionalidade varchar(60) not null,

    primary key (id)
);

INSERT INTO Nacionalidade_Veiculo(id, nacionalidade) VALUES (1, 'NACIONAL');
INSERT INTO Nacionalidade_Veiculo(id, nacionalidade) VALUES (2, 'IMPORTADO');

create table Especie_Veiculo (
	id bigint not null auto_increment,
    especie varchar(60) not null,

    primary key (id)
);

INSERT INTO Especie_Veiculo(id, especie) VALUES (1, 'PASSAGEIRO');
INSERT INTO Especie_Veiculo(id, especie) VALUES (2, 'CARGA');
INSERT INTO Especie_Veiculo(id, especie) VALUES (3, 'MISTO');
INSERT INTO Especie_Veiculo(id, especie) VALUES (4, 'COMPETICAO');
INSERT INTO Especie_Veiculo(id, especie) VALUES (5, 'TRACAO');
INSERT INTO Especie_Veiculo(id, especie) VALUES (6, 'ESPECIAL');
INSERT INTO Especie_Veiculo(id, especie) VALUES (7, 'COLECAO');

create table Categoria_Veiculo (
	id bigint not null auto_increment,
    categoria varchar(60) not null,

    primary key (id)
);

INSERT INTO Categoria_Veiculo(id, categoria) VALUES (1, 'PARTICULAR');
INSERT INTO Categoria_Veiculo(id, categoria) VALUES (2, 'OFICIAL');
INSERT INTO Categoria_Veiculo(id, categoria) VALUES (3, 'REPRESENTACAO');
INSERT INTO Categoria_Veiculo(id, categoria) VALUES (4, 'ALUGUEL');
INSERT INTO Categoria_Veiculo(id, categoria) VALUES (5, 'APRENDIZAGEM');