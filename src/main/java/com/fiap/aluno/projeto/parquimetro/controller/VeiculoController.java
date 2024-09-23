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

    @GetMapping("/{placa}")
    public Veiculo obterPorPlaca(@PathVariable String placa){
        return this.veiculoService.obterPorPlaca(placa);
    }

    @PostMapping
    public Veiculo criar(@RequestBody Veiculo veiculo){
        return this.veiculoService.criar(veiculo);
    }

    @PutMapping
    public void atualizar(@RequestBody Veiculo veiculo){
        this.veiculoService.atualizar(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deleteVeiculo(@PathVariable String id){
        this.veiculoService.deleteById(id);
    }

}
