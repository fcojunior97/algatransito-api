package com.algaworks.algatransito.api.representationmodel;

import com.algaworks.algatransito.domain.model.StatusVeiculo;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VeiculoResumoModel {

    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private String renavam;
    private String chassi;
    private String nacionalidade;
    private String municipio;
    private StatusVeiculo status;
   ;

}
