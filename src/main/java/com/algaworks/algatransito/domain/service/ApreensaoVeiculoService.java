package com.algaworks.algatransito.domain.service;

import com.algaworks.algatransito.domain.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApreensaoVeiculoService {

    @Autowired
    private VeiculoService veiculoService;

    @Transactional
    public void apreender(Long veiculoId) {
        Veiculo veiculo = veiculoService.buscarOuFalhar(veiculoId);
        veiculo.apreender();
    }

    @Transactional
    public void removerApreensao(Long veiculoId) {
        Veiculo veiculo = veiculoService.buscarOuFalhar(veiculoId);
        veiculo.removerApreensao();
    }


}
