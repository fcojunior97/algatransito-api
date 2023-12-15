package com.algaworks.algatransito.api.assembler;

import com.algaworks.algatransito.api.representationmodel.VeiculoModel;
import com.algaworks.algatransito.domain.model.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VeiculoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public VeiculoModel toModel(Veiculo veiculo) {
        return modelMapper.map(veiculo, VeiculoModel.class);
    }

    public List<VeiculoModel> toCollectionModel (List<Veiculo> veiculos) {
        return veiculos.stream()
                .map(veiculo -> toModel(veiculo))
                .collect(Collectors.toList());
    }


}
