package com.algaworks.algatransito.api.assembler;

import com.algaworks.algatransito.api.representationmodel.AutuacaoModel;
import com.algaworks.algatransito.domain.model.Autuacao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutuacaoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public AutuacaoModel toModel(Autuacao autuacao) {
        return modelMapper.map(autuacao, AutuacaoModel.class);
    }

    public List<AutuacaoModel> toCollectionModel(List<Autuacao> autuacoes) {
        return autuacoes.stream()
                .map(autuacao -> toModel(autuacao))
                .toList();
    }
}
