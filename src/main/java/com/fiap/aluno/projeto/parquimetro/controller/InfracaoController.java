package com.fiap.aluno.projeto.parquimetro.controller;

import com.fiap.aluno.projeto.parquimetro.model.Infracao;
import com.fiap.aluno.projeto.parquimetro.service.InfracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/infracoes")
public class InfracaoController {

    @Autowired
    private InfracaoService infracaoService;

    @GetMapping
    public List<Infracao> obterTodos(){
        return this.infracaoService.obterTodos();
    }
    @GetMapping("/{codigo}")
    public Infracao obterPorCodigo(@PathVariable String codigo){
        return this.infracaoService.obterPorCodigo(codigo);
    }
    @PostMapping
    public Infracao criar(@RequestBody Infracao infracao){
        return this.infracaoService.criar(infracao);
    }

}
