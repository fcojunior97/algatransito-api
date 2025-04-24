package com.algaworks.algatransito.domain.service;

import com.algaworks.algatransito.api.disassembler.VeiculoDisassembler;
import com.algaworks.algatransito.api.representationmodel.input.VeiculoInput;
import com.algaworks.algatransito.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algatransito.domain.exception.NegocioException;
import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.model.StatusVeiculo;
import com.algaworks.algatransito.domain.model.Veiculo;
import com.algaworks.algatransito.domain.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private RegistroProprietarioService registroProprietarioService;

    @Autowired
    private VeiculoDisassembler veiculoDisassembler;

    @Transactional
    public Veiculo cadastrar(Veiculo novoVeiculo) {

        validarSeNovoVeiculoNaoPossuiId(novoVeiculo);
        validarSeJaExisteVeiculoComMesmaPlaca(novoVeiculo);

        Proprietario proprietario = registroProprietarioService.buscarOuFalhar(novoVeiculo.getProprietario().getId());

        novoVeiculo.setProprietario(proprietario);
        novoVeiculo.setStatus(StatusVeiculo.EM_CIRCULACAO);
        novoVeiculo.setDataCadastro(OffsetDateTime.now());

        return veiculoRepository.save(novoVeiculo);
    }

    @Transactional
    public Veiculo atualizarDadosVeiculo(VeiculoInput veiculoInput, Veiculo veiculoAtual) {
        veiculoDisassembler.copyToDomainObject(veiculoInput, veiculoAtual);
        return veiculoRepository.save(veiculoAtual);
    }

    public Veiculo buscarOuFalhar(Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veiculo não encontrado com esse ID"));
    }

    public Veiculo buscarOuFalharPorPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veiculo não encontrado com essa identificação: " + placa));
    }

    private void validarSeNovoVeiculoNaoPossuiId(Veiculo novoVeiculo) {
        if(novoVeiculo.getId() != null) {
            throw new NegocioException("Veiculo a ser cadastrado não deve possuir um código");
        }
    }

    private void validarSeJaExisteVeiculoComMesmaPlaca (Veiculo novoVeiculo) {
        boolean placaCadastrada = veiculoRepository.findByPlaca(novoVeiculo.getPlaca())
                .filter(veiculo-> !veiculo.equals(novoVeiculo))
                .isPresent();

        if(placaCadastrada) {
            throw new NegocioException("Este veiculo não pode ser cadastrado, pois já existe veiculo cadastrado com essa placa");
        }
    }
}
