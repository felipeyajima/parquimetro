package com.fiap.aluno.projeto.parquimetro.controller;

import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import com.fiap.aluno.projeto.parquimetro.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "verificaveiculoestacionado")
public class VerificaCarroEstacionadoController {

    @Autowired
    private VeiculoService veiculoService;



    @GetMapping
    public Veiculo obterPorPlaca(
            @RequestParam("placa") String placa
    ){

        LocalDateTime horaDaVerificacao = LocalDateTime.now();

        Veiculo veiculo = this.veiculoService.obterPorPlaca(placa);

        LocalDateTime horaDaCompraDoBilhete = veiculo.getUltimoBilheteValido().getBilheteCompradoEm();
        Long horasCompradas = Long.valueOf(veiculo.getUltimoBilheteValido().getQuantidadeDeHorasAdquiridas());

        LocalDateTime vencimentoBilhete = horaDaCompraDoBilhete.plusHours(horasCompradas);

        System.out.println("vencimento do bilhete é: " + vencimentoBilhete);

        if(vencimentoBilhete.isBefore(horaDaVerificacao)){
            System.out.println("multa emitida");
            // emite multa
        } else {
            // nao emite multa
            System.out.println("multa nao emitida");
        }


        return null;
    }

}
