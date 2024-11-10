package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.domain.service.ApreensaoVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/veiculos/{placaVeiculo}/apreensao"))
public class ApreensaoVeiculoController {

    @Autowired
    private ApreensaoVeiculoService apreensaoVeiculoService;

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apreender(@PathVariable String placaVeiculo){
        apreensaoVeiculoService.apreender(placaVeiculo);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerApreencao(@PathVariable String placaVeiculo){ apreensaoVeiculoService.removerApreensao(placaVeiculo); }
}
