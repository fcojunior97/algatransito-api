package com.algaworks.algatransito.api.representationmodel;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class CnhResumoModel {

    private String numeroRegistro;
    private String categoriaCnh;
    private OffsetDateTime validade;
    private String tipo;
}
