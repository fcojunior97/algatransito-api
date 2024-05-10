package com.algaworks.algatransito.api.representationmodel;

import com.algaworks.algatransito.domain.model.Cnh;
import com.algaworks.algatransito.domain.model.Veiculo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class AutuacaoModel {

    private Long id;
    private VeiculoModelAutuacao veiculo;
    private CnhModelAutuacao cnh;
    private String descricao;
    private BigDecimal valorMulta;
    private OffsetDateTime dataOcorrencia;


}
