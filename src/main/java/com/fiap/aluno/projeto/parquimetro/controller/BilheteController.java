package com.fiap.aluno.projeto.parquimetro.controller;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import com.fiap.aluno.projeto.parquimetro.service.BilheteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
        return this.bilheteService.criar(bilhete);
    }

    @PutMapping
    public void atualizar(@RequestBody Bilhete bilhete){
        this.bilheteService.atualizar(bilhete);
    }



    //@GetMapping("/ultimobilheteporplaca/{id}")
    //public List<Bilhete> LastfindedByPlaca(@RequestParam("id") String id ){
    //    return this.bilheteService.buscaUltimoBilhetePorCarro(id);
    //}

    @DeleteMapping("/{codigo}")
    public void deleteBilhete(@PathVariable String codigo){
        this.bilheteService.deleteById(codigo);
    }


    @GetMapping("/bilhetesexpirando")
    public List<Bilhete> obterBilhetesPrestesAExpirar(
            @RequestParam("de") LocalDateTime de,
            @RequestParam("ate") LocalDateTime ate
    ){
        return this.bilheteService.obterBilhetesPrestesAExpirar(de, ate);
    }

    @GetMapping("/pagina-bilhetes")
    public ResponseEntity<Page<Bilhete>> obterBilhetesPaginados(Pageable pageable){
        Page<Bilhete> bilhetes = this.bilheteService.obterBilhetesPaginados(pageable);
        return ResponseEntity.ok(bilhetes);
    }

    @GetMapping("/bilhetes-ordenados-data")
    public List<Bilhete> findByCpfDoClienteOrderByBilheteCompradoEmAsc(@RequestParam("cpf") String cpfDoCliente){
        return this.bilheteService.findByCpfDoClienteOrderByBilheteCompradoEmAsc(cpfDoCliente);
    }

    /* PESQUISA DINAMICA COM MONGODB - MUITO UTILIZADO NO MERCADO
    @GetMapping("/bilhetepesquisadinamica")
    public List<Bilhete> encontrarBilhetesPesquisaDinamica(
            @RequestParam Integer quantidadeDeHorasAdquiridas,
            @RequestParam LocalDateTime data
    ){
        return this.bilheteService.encontrarBilhetesPesquisaDinamica(quantidadeDeHorasAdquiridas, data);
    }*/

}
