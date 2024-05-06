ALTER TABLE autuacao ADD cnh_id bigint;

alter table autuacao add constraint fk_autuacao_cnh foreign key (cnh_id) references cnh (id);