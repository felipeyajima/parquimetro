package com.fiap.aluno.projeto.parquimetro.controller;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bilhetes")
public class BilheteController {

    @GetMapping
    public List<Bilhete> obterTodos(){
        return null;
    }

    @GetMapping("/{codigo}")
    public Bilhete obterPorCodigo(@PathVariable String codigo){
        return null;
    }

    @PostMapping
    public Bilhete criar(@RequestBody Bilhete bilhete){
        return null;
    }



}
