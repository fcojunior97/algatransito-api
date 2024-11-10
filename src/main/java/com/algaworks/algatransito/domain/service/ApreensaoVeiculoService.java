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
    public void apreender(String placaVeiculo) {
        Veiculo veiculo = veiculoService.buscarOuFalharPorPlaca(placaVeiculo);
        veiculo.apreender();
    }

    @Transactional
    public void removerApreensao(String placaVeiculo) {
        Veiculo veiculo = veiculoService.buscarOuFalharPorPlaca(placaVeiculo);
        veiculo.removerApreensao();
    }


}
