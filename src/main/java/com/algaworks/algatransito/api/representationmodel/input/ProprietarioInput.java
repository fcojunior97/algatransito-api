package com.algaworks.algatransito.api.representationmodel.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProprietarioInput {

    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
    @Size(max = 60)
    @Email
    private String email;

    @NotBlank
    @Size(max = 20)
    private String telefone;
}
