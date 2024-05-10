package com.algaworks.algatransito.domain.model;

import com.algaworks.algatransito.api.representationmodel.AutuacaoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cnh {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    private String numeroRegistro;

    private String categoriaCnh;

    private OffsetDateTime validade;

    private String tipo;

    @OneToMany(mappedBy = "cnh", cascade = CascadeType.ALL)
    private List<Autuacao> autuacoes = new ArrayList<>();


    public OffsetDateTime definirValidade(Proprietario proprietario) {
        OffsetDateTime dataAtual = OffsetDateTime.now();
        OffsetDateTime validade = OffsetDateTime.now();

        int idadeProprietario = proprietario.calculaIdadeProprietario();

        if(this.getTipo().equals("PERMISSAO")) {
            validade = dataAtual.plusYears(1);
        } else if (this.getTipo().equals("DEFINITIVA")) {
            if(idadeProprietario < 50) {
                validade = dataAtual.plusYears(10);
            } else if (idadeProprietario >= 50 && idadeProprietario <= 69) {
                validade = dataAtual.plusYears(5);
            } else if (idadeProprietario >= 70) {
                validade = dataAtual.plusYears(3);
            }
        }

        return validade;
    }


}
