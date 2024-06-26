package com.algaworks.algatransito.api.config;

import com.algaworks.algatransito.api.representationmodel.AutuacaoModel;
import com.algaworks.algatransito.api.representationmodel.CnhModel;
import com.algaworks.algatransito.api.representationmodel.ProprietarioModel;
import com.algaworks.algatransito.domain.model.Cnh;
import com.algaworks.algatransito.domain.model.Proprietario;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.OffsetDateTime;
import java.util.List;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper () {

        var modelMapper =  new ModelMapper();

//        modelMapper.typeMap(Proprietario.class, ProprietarioModel.class).addMappings(mapper -> {
//            mapper.map(src -> src.getCnh().getId(), (dest, value) -> dest.getCnh().setId((Long) value));
//            mapper.map(src -> src.getCnh().getProprietario().getCpf(), (dest, value) -> dest.getCnh().getProprietario().setNome((String) value));
//            mapper.map(src -> src.getCnh().getNumeroRegistro(), (dest, value) -> dest.getCnh().setNumeroRegistro((String) value));
//            mapper.map(src -> src.getCnh().getCategoriaCnh(), (dest, value) -> dest.getCnh().setCategoriaCnh((String) value));
//            mapper.map(src -> src.getCnh().getValidade(), (dest, value) -> dest.getCnh().setValidade((OffsetDateTime) value));
//            mapper.map(src -> src.getCnh().getTipo(), (dest, value) -> dest.getCnh().setTipo((String) value));
//        });

        return modelMapper;
    }
}
