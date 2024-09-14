package com.fiap.aluno.projeto.parquimetro.controller;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import com.fiap.aluno.projeto.parquimetro.service.BilheteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bilhetes")
public class BilheteController {

    @Autowired
    private BilheteService bilheteService;
    @GetMapping
    public List<Bilhete> obterTodos(){
        return this.bilheteService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Bilhete obterPorCodigo(@PathVariable String codigo){
        return this.bilheteService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Bilhete criar(@RequestBody Bilhete bilhete){
        return this.criar(bilhete);
    }



}
