package com.algaworks.algatransito.domain.service;

import com.algaworks.algatransito.domain.exception.NegocioException;
import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    @Transactional
    public Proprietario salvar(Proprietario proprietario) {

        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail())
                .filter(p-> !p.equals(proprietario))
                .isPresent();

        if(emailEmUso) {
            throw new NegocioException("Este email não está disponivel, tente novamente com outro e-mail válido!");
        }

        return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void excluir(String cpf) {
        proprietarioRepository.deleteByCpf(cpf);
    }

    public Proprietario buscarOuFalhar(Long idProprietario) {
        return proprietarioRepository.findById(idProprietario)
                .orElseThrow(() -> new NegocioException("Proprietario não encontrado com esse ID"));
    }

    public Optional<Proprietario> buscarOuFalharPorCpf(String cpf) {
        return proprietarioRepository.findByCpf(cpf);
    }
}
