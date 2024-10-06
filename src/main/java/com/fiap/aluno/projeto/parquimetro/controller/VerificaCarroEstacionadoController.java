package com.fiap.aluno.projeto.parquimetro.controller;

import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import com.fiap.aluno.projeto.parquimetro.service.VeiculoService;
import com.fiap.aluno.projeto.parquimetro.service.VerificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "verificaveiculoestacionado")
public class VerificaCarroEstacionadoController {

    @Autowired
    private VerificacaoService verificacaoService;

    @GetMapping
    public void verificao(
            @RequestParam("placa") String placa
    ){
        this.verificacaoService.verifica(placa);

    }

}
