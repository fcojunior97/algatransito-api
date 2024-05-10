package com.algaworks.algatransito.api.representationmodel;

import com.algaworks.algatransito.domain.model.Autuacao;
import com.algaworks.algatransito.domain.model.Proprietario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CnhModel {

    private Long id;
    private ProprietarioResumoModel proprietario;
    private String numeroRegistro;
    private String categoriaCnh;
    private OffsetDateTime validade;
    private String tipo;
    private List<AutuacaoModel> autuacoes = new ArrayList<>();
}
