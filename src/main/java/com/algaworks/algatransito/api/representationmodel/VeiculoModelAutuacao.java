package com.algaworks.algatransito.api.representationmodel;

import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.model.StatusVeiculo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VeiculoModelAutuacao {

    private Long id;

    private ProprietarioResumoModel proprietario;

    private String marca;
    private String modelo;
    private String placa;
    private String renavam;
    private String restricao;
    private StatusVeiculo status;
    private String observacao;
    private OffsetDateTime dataApreensao;

}
