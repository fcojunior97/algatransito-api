package com.algaworks.algatransito.api.disassembler;

import com.algaworks.algatransito.api.representationmodel.VeiculoModel;
import com.algaworks.algatransito.api.representationmodel.input.VeiculoInputModel;
import com.algaworks.algatransito.domain.model.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VeiculoDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Veiculo toEntity(VeiculoInputModel veiculoInput) {
        return modelMapper.map(veiculoInput, Veiculo.class);
    }
}
