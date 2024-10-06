package com.fiap.aluno.projeto.parquimetro.service.impl;

import com.fiap.aluno.projeto.parquimetro.model.Infracao;
import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import com.fiap.aluno.projeto.parquimetro.service.InfracaoService;
import com.fiap.aluno.projeto.parquimetro.service.VeiculoService;
import com.fiap.aluno.projeto.parquimetro.service.VerificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificacaoServiceImpl implements VerificacaoService {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private InfracaoService infracaoService;

    @Override
    public void verifica(String placa) {
        LocalDateTime horaDaVerificacao = LocalDateTime.now();

        Veiculo veiculo = this.veiculoService.obterPorPlaca(placa);

        LocalDateTime horaDaCompraDoBilhete = veiculo.getUltimoBilheteValido().getBilheteCompradoEm();
        Long horasCompradas = Long.valueOf(veiculo.getUltimoBilheteValido().getQuantidadeDeHorasAdquiridas());

        LocalDateTime vencimentoBilhete = horaDaCompraDoBilhete.plusHours(horasCompradas);

        System.out.println("vencimento do bilhete é: " + vencimentoBilhete);

        if(vencimentoBilhete.isBefore(horaDaVerificacao)){
            System.out.println("multa emitida");

            Veiculo veiculo1 = new Veiculo();
            veiculo1.setPlaca(placa);


            Infracao infracao = new Infracao();
            infracao.setVeiculo(veiculo1);
            infracao.setValorDaMulta(1000.0);
            infracao.setCepDoLocalDaInfracao("10000-000");

            this.infracaoService.criar(infracao);

        } else {
            // nao emite multa
            System.out.println("multa nao emitida");
        }
    }
}
