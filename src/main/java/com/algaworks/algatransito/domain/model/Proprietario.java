package com.algaworks.algatransito.domain.model;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.OffsetDateTime;
import java.time.Period;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Proprietario {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
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

    @OneToOne
    @JoinColumn(name = "cnh_id")
    private Cnh cnh;

    public int calculaIdadeProprietario() {

        OffsetDateTime dataNascimento = this.getDataNascimento();

        OffsetDateTime dataAtual = OffsetDateTime.now();

        // Calcula a diferença entre a data atual e a data de nascimento
        Period periodo = Period.between(dataNascimento.toLocalDate(), dataAtual.toLocalDate());

        int idadeCalculada = periodo.getYears();

        return idadeCalculada;

    }


}
