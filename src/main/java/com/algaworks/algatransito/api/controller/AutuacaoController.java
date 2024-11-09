package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.api.assembler.AutuacaoAssembler;
import com.algaworks.algatransito.api.disassembler.AutuacaoDisassembler;
import com.algaworks.algatransito.api.representationmodel.AutuacaoModel;
import com.algaworks.algatransito.api.representationmodel.input.AutuacaoInput;
import com.algaworks.algatransito.domain.model.Veiculo;
import com.algaworks.algatransito.domain.service.AutuacaoService;
import com.algaworks.algatransito.domain.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos/{placaVeiculo}/autuacoes")
public class AutuacaoController {

    @Autowired
    private AutuacaoService autuacaoService;

    @Autowired
    private AutuacaoDisassembler autuacaoDisassembler;

    @Autowired
    private AutuacaoAssembler autuacaoAssembler;

    @Autowired
    private VeiculoService veiculoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoModel registrar(@PathVariable String placaVeiculo,
                                   @Valid @RequestBody AutuacaoInput autuacaoInput) {
        var novaAtuacao = autuacaoDisassembler.toEntity(autuacaoInput);
        return autuacaoAssembler.toModel(autuacaoService.registrar(autuacaoInput.getCondutor(), placaVeiculo, novaAtuacao));
    }


    @GetMapping
    public List<AutuacaoModel> listarAutuacoes(@PathVariable String placaVeiculo) {
        Veiculo veiculo =  veiculoService.buscarOuFalharPorPlaca(placaVeiculo);
        return autuacaoAssembler.toCollectionModel(veiculo.getAutuacoes());
    }
}
