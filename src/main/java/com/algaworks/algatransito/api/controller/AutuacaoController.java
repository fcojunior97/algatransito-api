package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.api.assembler.AutuacaoAssembler;
import com.algaworks.algatransito.api.disassembler.AutuacaoDisassembler;
import com.algaworks.algatransito.api.representationmodel.AutuacaoModel;
import com.algaworks.algatransito.api.representationmodel.input.AutuacaoInput;
import com.algaworks.algatransito.domain.model.Autuacao;
import com.algaworks.algatransito.domain.service.AutuacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {

    @Autowired
    private AutuacaoService autuacaoService;

    @Autowired
    private AutuacaoDisassembler autuacaoDisassembler;

    @Autowired
    private AutuacaoAssembler autuacaoAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoModel registrar(@PathVariable Long veiculoId,
                                   @Valid @RequestBody AutuacaoInput autuacaoInput) {
        var novaAtuacao = autuacaoDisassembler.toEntity(autuacaoInput);
        return autuacaoAssembler.toModel(autuacaoService.registrar(veiculoId, novaAtuacao));
    }
}
