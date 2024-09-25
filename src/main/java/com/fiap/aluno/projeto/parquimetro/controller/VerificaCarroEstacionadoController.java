package com.fiap.aluno.projeto.parquimetro.controller;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import com.fiap.aluno.projeto.parquimetro.service.BilheteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "verificaveiculoestacionado")
public class VerificaCarroEstacionadoController {

    @Autowired
    private BilheteService bilheteService;


    // estamos utilizando uma nova forma de consulta utilizando Query Methods
    @GetMapping
    public Bilhete findByVeiculoPlacaAndBilheteCompradoEmGreaterThan(
            @RequestParam("placa") String placa,
            @RequestParam("data") LocalDateTime data
    ){
        return this.bilheteService.findByVeiculoPlacaAndBilheteCompradoEmGreaterThan(placa, data);
    }

}
