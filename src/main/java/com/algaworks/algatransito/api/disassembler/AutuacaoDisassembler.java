package com.algaworks.algatransito.api.disassembler;

import com.algaworks.algatransito.api.representationmodel.input.AutuacaoInput;
import com.algaworks.algatransito.domain.model.Autuacao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutuacaoDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Autuacao toEntity(AutuacaoInput autuacaoInput) {
        return modelMapper.map(autuacaoInput, Autuacao.class);
    }

}
