package com.algaworks.algatransito.api.representationmodel.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CnhInputRenovacao {


    @NotBlank
    private String categoriaCnh;


}
