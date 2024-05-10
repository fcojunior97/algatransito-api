package com.algaworks.algatransito.api.representationmodel;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CnhModelAutuacao {

    private Long id;
    private ProprietarioResumoModel proprietario;
    private String numeroRegistro;

}
