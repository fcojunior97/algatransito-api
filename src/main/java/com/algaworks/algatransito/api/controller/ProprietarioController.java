package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.api.assembler.ProprietarioAssembler;
import com.algaworks.algatransito.api.disassembler.ProprietarioDisassembler;
import com.algaworks.algatransito.api.representationmodel.ProprietarioModel;
import com.algaworks.algatransito.api.representationmodel.input.ProprietarioInput;
import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.repository.ProprietarioRepository;
import com.algaworks.algatransito.domain.service.RegistroProprietarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @Autowired
    private RegistroProprietarioService registroProprietarioService;

    @Autowired
    private ProprietarioAssembler proprietarioAssembler;

    @Autowired
    private ProprietarioDisassembler proprietarioDisassembler;

    @GetMapping
    public List<ProprietarioModel> listar() {
        return proprietarioAssembler.toCollectionModel(proprietarioRepository.findAll());
    }


    @GetMapping("/{cpf}")
    public ResponseEntity<ProprietarioModel> buscarProprietarioPorCpf(@PathVariable String cpf) {
        return proprietarioRepository.findByCpf(cpf)
                .map(proprietario -> proprietarioAssembler.toModel(proprietario))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ProprietarioModel cadastrar(@RequestBody @Valid ProprietarioInput proprietarioInput) {
        Proprietario proprietario = proprietarioDisassembler.toEntity(proprietarioInput);
        return proprietarioAssembler.toModel(registroProprietarioService.salvar(proprietario));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Proprietario> atualizar(@PathVariable String cpf, @RequestBody @Valid ProprietarioInput proprietarioInput) {

        Optional<Proprietario> proprietarioExistente = proprietarioRepository.findByCpf(cpf);

        if(proprietarioExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Proprietario proprietario = proprietarioDisassembler.toEntity(proprietarioInput);
        proprietario.setId(proprietarioExistente.get().getId());
        Proprietario proprietarioAtualizado = registroProprietarioService.salvar(proprietario);
        return ResponseEntity.ok().body(proprietarioAtualizado);

    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> remover(@PathVariable String cpf) {

        if(proprietarioRepository.findByCpf(cpf).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        registroProprietarioService.excluir(cpf);
        return ResponseEntity.noContent().build();

    }


}
