package com.algaworks.algatransito.api.representationmodel;

import com.algaworks.algatransito.domain.model.Endereco;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.OffsetDateTime;

@Getter
@Setter
public class ProprietarioModel {

    private Long id;
    private String nome;
    private String cpf;
    private OffsetDateTime dataNascimento;
    private Endereco endereco;
    private String email;
    private String telefone;

}
