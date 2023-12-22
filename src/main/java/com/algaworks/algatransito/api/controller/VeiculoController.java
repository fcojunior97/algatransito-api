package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.api.assembler.VeiculoAssembler;
import com.algaworks.algatransito.api.disassembler.VeiculoDisassembler;
import com.algaworks.algatransito.api.representationmodel.VeiculoModel;
import com.algaworks.algatransito.api.representationmodel.input.VeiculoInput;
import com.algaworks.algatransito.domain.model.Veiculo;
import com.algaworks.algatransito.domain.repository.VeiculoRepository;
import com.algaworks.algatransito.domain.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private VeiculoAssembler veiculoAssembler;

    @Autowired
    private VeiculoDisassembler veiculoDisassembler;

    @GetMapping
    public List<VeiculoModel> listar() {
        return veiculoAssembler.toCollectionModel(veiculoRepository.findAll());
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoModel> buscar (@PathVariable Long veiculoId){
        return veiculoRepository.findById(veiculoId)
                .map(veiculo -> veiculoAssembler.toModel(veiculo))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoModel cadastrar (@RequestBody @Valid VeiculoInput veiculoInput){
        Veiculo novoVeiculo = veiculoDisassembler.toEntity(veiculoInput);
        return veiculoAssembler.toModel(veiculoService.cadastrar(novoVeiculo));
    }

    @PutMapping("/{veiculoId}")
    public VeiculoModel atualizar (@PathVariable Long veiculoId, @RequestBody @Valid VeiculoInput veiculoInput){
        Veiculo veiculoAtual = veiculoService.buscarOuFalhar(veiculoId);
        Veiculo veiculoAtualizado = veiculoService.atualizarDadosVeiculo(veiculoInput, veiculoAtual);

        return veiculoAssembler.toModel(veiculoAtualizado);
    }

}
