package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.api.assembler.CnhAssembler;
import com.algaworks.algatransito.api.disassembler.CnhDisassembler;
import com.algaworks.algatransito.api.representationmodel.CnhModel;
import com.algaworks.algatransito.api.representationmodel.input.CnhInput;
import com.algaworks.algatransito.domain.model.Cnh;
import com.algaworks.algatransito.domain.model.Veiculo;
import com.algaworks.algatransito.domain.repository.CnhRepository;
import com.algaworks.algatransito.domain.service.CnhService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cnhs")
public class CnhController {

    @Autowired
    private CnhRepository cnhRepository;

    @Autowired
    private CnhService cnhService;

    @Autowired
    private CnhAssembler cnhAssembler;

    @Autowired
    private CnhDisassembler cnhDisassembler;

    @GetMapping
    public List<CnhModel> listar() {
        List<Cnh> cnhs = cnhRepository.findAll();
        return cnhAssembler.toCollectionModel(cnhs);
    }

    @GetMapping("/{numeroRegistro}")
    public CnhModel buscarPorNumeroRegistro(@PathVariable String numeroRegistro) {
        Cnh cnh = cnhService.buscarOuFalhar(numeroRegistro);
        return cnhAssembler.toModel(cnh);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CnhModel cadastrar(@RequestParam String cpf, @Valid @RequestBody CnhInput cnhInput) {
        Cnh novaCnh = cnhDisassembler.toEntity(cnhInput);
        Cnh cnhSalva = cnhService.salvar(cpf, novaCnh);
        return cnhAssembler.toModel(cnhSalva);
    }

    @PutMapping("/{numeroRegistro}")
    public CnhModel atualizar(@PathVariable String numeroRegistro, @Valid @RequestBody CnhInput cnhInput) {
        Cnh cnhAtual = cnhService.buscarOuFalhar(numeroRegistro);
        Cnh cnhAtualizada = cnhService.atualizarDadosCnh(cnhInput, cnhAtual);

        return cnhAssembler.toModel(cnhAtualizada);
    }
}
