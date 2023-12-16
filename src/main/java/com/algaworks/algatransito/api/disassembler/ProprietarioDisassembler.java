package com.algaworks.algatransito.api.disassembler;

import com.algaworks.algatransito.api.representationmodel.input.ProprietarioInput;
import com.algaworks.algatransito.domain.model.Proprietario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProprietarioDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Proprietario toEntity(ProprietarioInput proprietarioInput) {
        return modelMapper.map(proprietarioInput, Proprietario.class);
    }

}
