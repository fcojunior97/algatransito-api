package com.algaworks.algatransito.api.disassembler;

import com.algaworks.algatransito.api.representationmodel.input.CnhInput;
import com.algaworks.algatransito.api.representationmodel.input.ProprietarioInput;
import com.algaworks.algatransito.api.representationmodel.input.VeiculoInput;
import com.algaworks.algatransito.domain.model.Cnh;
import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.model.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CnhDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cnh toEntity(CnhInput cnhInput) {
        return modelMapper.map(cnhInput, Cnh.class);
    }

    public void copyToDomainObject(CnhInput cnhInput, Cnh cnh) {
        modelMapper.map(cnhInput, cnh);

    }
}
