package com.algaworks.algatransito.api.representationmodel.input;

import com.algaworks.algatransito.api.representationmodel.ProprietarioResumoModel;
import com.algaworks.algatransito.domain.model.StatusVeiculo;
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
public class VeiculoInputModel {

    @Valid
    @NotNull
    private ProprietarioIdInput proprietario;

    @NotBlank
    @Size(max=20)
    private String marca;

    @NotBlank
    @Size(max=20)
    private String modelo;

    @NotBlank
    @Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}")
    private String placa;

    private OffsetDateTime dataApreensao;

}
