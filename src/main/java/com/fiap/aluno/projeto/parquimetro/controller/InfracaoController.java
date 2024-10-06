package com.fiap.aluno.projeto.parquimetro.controller;

import com.fiap.aluno.projeto.parquimetro.model.Infracao;
import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import com.fiap.aluno.projeto.parquimetro.service.InfracaoService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/infracoes")
public class InfracaoController {

    @Autowired
    private InfracaoService infracaoService;


    @GetMapping
    public ResponseEntity<Page<Infracao>> findAll(Pageable pageable){
        Page<Infracao> infracoes = this.infracaoService.findAll(pageable);
        return ResponseEntity.ok(infracoes);
    }

    @GetMapping("/{codigo}")
    public Infracao obterPorCodigo(@PathVariable String codigo){
        return this.infracaoService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Infracao criar(@RequestBody Infracao infracao){
        return this.infracaoService.criar(infracao);
    }

    @PutMapping
    public void atualizar(@RequestBody Infracao infracao){
        this.infracaoService.atualizar(infracao);
    }

    @DeleteMapping("/{codigo}")
    public void deleteInfracao(@PathVariable String codigo){
        this.infracaoService.deleteById(codigo);
    }



}
