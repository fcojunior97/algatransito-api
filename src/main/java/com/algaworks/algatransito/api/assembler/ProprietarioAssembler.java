package com.algaworks.algatransito.api.assembler;

import com.algaworks.algatransito.api.representationmodel.ProprietarioModel;
import com.algaworks.algatransito.domain.model.Proprietario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProprietarioAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ProprietarioModel toModel(Proprietario proprietario) {
        return modelMapper.map(proprietario, ProprietarioModel.class);
    }

    public List<ProprietarioModel> toCollectionModel(List<Proprietario> proprietarios) {
        return proprietarios.stream()
                .map(proprietario -> toModel(proprietario))
                .toList();
    }

}
