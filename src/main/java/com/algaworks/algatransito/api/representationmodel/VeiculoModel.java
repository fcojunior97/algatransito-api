package com.algaworks.algatransito.api.representationmodel;

import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.model.StatusVeiculo;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class VeiculoModel {


    private Long id;
    private ProprietarioResumoModel proprietario;
    private String marca;
    private String modelo;
    private String placa;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataApreensao;
    private StatusVeiculo status;
}
