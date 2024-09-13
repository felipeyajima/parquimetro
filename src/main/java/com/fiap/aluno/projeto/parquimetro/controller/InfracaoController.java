package com.fiap.aluno.projeto.parquimetro.controller;

import com.fiap.aluno.projeto.parquimetro.model.Infracao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/infracoes")
public class InfracaoController {
    @GetMapping
    public List<Infracao> obterTodos(){
        return null;
    }
    @GetMapping("/{codigo}")
    public Infracao obterPorCodigo(@PathVariable String codigo){
        return null;
    }
    @PostMapping
    public Infracao criar(@RequestBody Infracao infracao){
        return null;
    }

}
