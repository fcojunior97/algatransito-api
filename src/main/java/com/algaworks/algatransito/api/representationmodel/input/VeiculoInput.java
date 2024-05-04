package com.algaworks.algatransito.api.representationmodel.input;

import com.algaworks.algatransito.domain.model.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class VeiculoInput {

    @Valid
    @NotNull
    private ProprietarioIdInput proprietario;

    @NotBlank
    @Size(max=20)
    private String marca;

    @NotBlank
    @Size(max=60)
    private String modelo;

    @NotBlank
    private String cor;

    @NotBlank
    @Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}")
    private String placa;

    @NotBlank
    @Size(max=11)
    private String renavam;

    @NotBlank
    @Size(max=17)
    private String chassi;

    @NotBlank
    @Size(max=15)
    private String anoFabricacaoModelo;

    @NotBlank
    private String tipo;

    @NotBlank
    @Size(max=20)
    private String combustivel;

    @NotBlank
    private String categoria;

    @NotBlank
    private String especie;

    @NotBlank
    private String nacionalidade;

    @NotBlank
    @Size(max=20)
    private String potenciaCilindradas;

    @NotBlank
    @Size(max=20)
    private String capacidadePassageiros;

    @NotBlank
    @Size(max=20)
    private String municipio;

    @NotBlank
    @Size(max=4)
    private String licenciamento;

    @NotBlank
    @Size(max=255)
    private String observacao;


}
