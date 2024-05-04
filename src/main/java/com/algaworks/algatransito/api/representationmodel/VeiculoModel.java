package com.algaworks.algatransito.api.representationmodel;

import com.algaworks.algatransito.domain.model.*;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VeiculoModel {

    private Long id;

    private Proprietario proprietario;

    private String marca;
    private String modelo;

    private String cor;

    private String placa;
    private String renavam;
    private String chassi;
    private String anoFabricacaoModelo;

    private String tipo;

    private String combustivel;

    private String categoria;

    private String especie;

    private String nacionalidade;

    private String potenciaCilindradas;
    private String capacidadePassageiros;
    private String municipio;

    private StatusVeiculo status;

    private String licenciamento;
    private String observacao;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataApreensao;

    private List<Autuacao> autuacoes = new ArrayList<>();
}
