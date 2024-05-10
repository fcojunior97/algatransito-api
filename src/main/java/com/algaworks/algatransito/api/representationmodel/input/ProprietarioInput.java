package com.algaworks.algatransito.api.representationmodel.input;

import com.algaworks.algatransito.domain.model.Cnh;
import com.algaworks.algatransito.domain.model.Endereco;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.OffsetDateTime;

@Getter
@Setter
public class ProprietarioInput {

    @NotBlank
    @Size(max = 60)
    private String nome;

    @CPF
    private String cpf;

    @NotNull
    private OffsetDateTime dataNascimento;

    @Valid
    @Embedded
    private Endereco endereco;

    @NotBlank
    @Size(max = 60)
    @Email
    private String email;

    @NotBlank
    @Size(max = 20)
    private String telefone;

}
