package com.algaworks.algatransito.api.representationmodel;

import com.algaworks.algatransito.domain.model.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VeiculoModel {


    private Long id;
    private ProprietarioResumoModel proprietario;
    private String marca;
    private String modelo;
    private CorVeiculo cor;
    private String placa;
    private String renavam;
    private String chassi;
    private String anoFabricacaoModelo;
    private TipoVeiculo tipo;
    private String combustivel;
    private CategoriaVeiculo categoria;
    private EspecieVeiculo especie;
    private Nacionalidade nacionalidade;
    private Restricao restricao;
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
