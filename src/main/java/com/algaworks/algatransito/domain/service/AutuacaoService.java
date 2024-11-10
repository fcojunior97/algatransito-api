package com.algaworks.algatransito.domain.service;

import com.algaworks.algatransito.domain.model.Autuacao;
import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AutuacaoService {


    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private RegistroProprietarioService proprietarioService;

    @Autowired
    private CnhService cnhCondutor;


    @Transactional
    public Autuacao registrar(String condutor, String placaVeiculo, Autuacao novaAutuacao) {
        Veiculo veiculo = veiculoService.buscarOuFalharPorPlaca(placaVeiculo);
        Optional<Proprietario> proprietario = proprietarioService.buscarOuFalharPorCpf(condutor);

        proprietario.ifPresent(value -> novaAutuacao.setCnh(value.getCnh()));
        veiculo.adicionarAutuacao(novaAutuacao);

        return novaAutuacao;
    }

}
