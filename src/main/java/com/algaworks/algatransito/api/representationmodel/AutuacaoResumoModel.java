package com.algaworks.algatransito.api.representationmodel;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class AutuacaoResumoModel {

    private Long id;
    private VeiculoResumoModel veiculo;
    private String descricao;
    private BigDecimal valorMulta;
    private OffsetDateTime dataOcorrencia;
}
