package com.algaworks.algatransito.api.assembler;

import com.algaworks.algatransito.api.representationmodel.CnhModel;
import com.algaworks.algatransito.domain.model.Cnh;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CnhAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CnhModel toModel(Cnh cnh) {
        return modelMapper.map(cnh, CnhModel.class);
    }

    public List<CnhModel> toCollectionModel(List<Cnh> cnhs) {
        return cnhs.stream()
                .map(this::toModel)
                .toList();
    }
}
