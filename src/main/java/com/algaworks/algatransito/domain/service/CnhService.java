package com.algaworks.algatransito.domain.service;

import com.algaworks.algatransito.api.disassembler.CnhDisassembler;
import com.algaworks.algatransito.api.representationmodel.input.CnhInput;
import com.algaworks.algatransito.api.representationmodel.input.CnhInputRenovacao;
import com.algaworks.algatransito.domain.exception.NegocioException;
import com.algaworks.algatransito.domain.model.Cnh;
import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.repository.CnhRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CnhService {

    @Autowired
    private CnhDisassembler cnhDisassembler;

    @Autowired
    private CnhRepository cnhRepository;

    @Autowired
    private RegistroProprietarioService proprietarioService;

    @Transactional
    public Cnh emitir(String cpf, Cnh cnh) {

        Cnh cnhGerada = this.gerarCnh(cpf, cnh);

        return cnhRepository.save(cnhGerada);
    }

    @Transactional
    public Cnh renovarCnh(String numeroRegistro, CnhInputRenovacao cnhInputRenovacao) {
        Cnh cnhAtual = cnhRepository.findByNumeroRegistro(numeroRegistro);

        if(cnhAtual == null) {
            throw new NegocioException("Não foi encontrada CNH em nossa base dados com esse número de registro");
        }
        Cnh cnhGerada = this.renovarCnh(cnhAtual, cnhInputRenovacao);

        return cnhRepository.save(cnhGerada);
    }

    @Transactional
    public Cnh atualizarDadosCnh(CnhInput cnhInput, Cnh cnhAtual) {
        cnhDisassembler.copyToDomainObject(cnhInput, cnhAtual);
        return cnhRepository.save(cnhAtual);
    }

    public Cnh buscarOuFalhar(String numeroRegistro) {
        Cnh cnh =  cnhRepository.findByNumeroRegistro(numeroRegistro);

        if(cnh != null) {
            return cnh;
        }else {
            throw new NegocioException("Não há CNH cadastrada em nosso sistema com esse número de registro");
        }
    }

    private Cnh gerarCnh(String cpf, Cnh cnh) {
        Optional<Proprietario> proprietario = proprietarioService.buscarOuFalharPorCpf(cpf);
        cnh.setProprietario(proprietario.get());

        cnh.setNumeroRegistro(UniqueRandomnNumRegistroCNHGenerator());
        cnh.setValidade(cnh.definirValidade(proprietario.get()));

        return cnh;

    }

    private Cnh renovarCnh(Cnh cnhAtual, CnhInputRenovacao cnhInputRenovacao) {

        cnhAtual.setTipo("DEFINITIVA");
        cnhAtual.setValidade(cnhAtual.definirValidade(cnhAtual.getProprietario()));

        return cnhAtual;

    }

    private String UniqueRandomnNumRegistroCNHGenerator() {

        Set<String> existingRegistros = new HashSet<>();
        cnhRepository.findAll().forEach(cnh -> existingRegistros.add(cnh.getNumeroRegistro()));

        long min = 10000000000L;
        long max = 99999999999L;

        while (true) {
            long randomNumber = ThreadLocalRandom.current().nextLong(min, max + 1);
            String novoRegistro = String.valueOf(randomNumber);

            if (!existingRegistros.contains(novoRegistro)) {
                return novoRegistro;
            }
        }

    }

}
