package com.algaworks.algatransito.domain.service;

import com.algaworks.algatransito.domain.exception.NegocioException;
import com.algaworks.algatransito.domain.model.StatusVeiculo;
import com.algaworks.algatransito.domain.model.Veiculo;
import com.algaworks.algatransito.domain.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional
    public Veiculo salvar(Veiculo novoVeiculo) {

        novoVeiculo.setStatus(StatusVeiculo.REGULAR);
        novoVeiculo.setDataCadastro(LocalDateTime.now());

        boolean placaCadastrada = veiculoRepository.findByPlaca(novoVeiculo.getPlaca())
                .filter(v-> !v.equals(novoVeiculo))
                .isPresent();

        if(placaCadastrada) {
            throw new NegocioException("Este veiculo não pode ser cadastrado, pois já existe veiculo cadastrado com essa placa");
        }

        return veiculoRepository.save(novoVeiculo);
    }
}
