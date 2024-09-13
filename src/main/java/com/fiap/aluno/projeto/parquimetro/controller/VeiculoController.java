package com.fiap.aluno.projeto.parquimetro.controller;

import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @GetMapping
    public List<Veiculo> obterTodos(){
        return null;
    }

    @GetMapping("/{codigo}")
    public Veiculo obterPorCodigo(@PathVariable String codigo){
        return null;
    }

    @PostMapping
    public Veiculo criar(@RequestBody Veiculo veiculo){
        return null;
    }



}
