package com.fiap.aluno.projeto.parquimetro.controller;

import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import com.fiap.aluno.projeto.parquimetro.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> obterTodos(){
        return this.veiculoService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Veiculo obterPorCodigo(@PathVariable String codigo){
        return this.veiculoService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Veiculo criar(@RequestBody Veiculo veiculo){
        return this.veiculoService.criar(veiculo);
    }



}
