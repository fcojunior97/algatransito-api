package com.algaworks.algatransito.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Endereco {

    @NotBlank
    @Column(name = "endereco_cep")
    private String cep;

    @NotBlank
    @Column(name = "endereco_rua")
    private String rua;

    @NotBlank
    @Column(name = "endereco_numero")
    private String numero;

    @NotBlank
    @Column(name = "endereco_bairro")
    private String bairro;

    @NotBlank
    @Column(name = "endereco_estado")
    private String estado;

    @NotBlank
    @Column(name = "endereco_complemento")
    private String complemento;
}
