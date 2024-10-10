package com.fiap.aluno.projeto.parquimetro.service.impl;

import com.fiap.aluno.projeto.parquimetro.model.Infracao;
import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import com.fiap.aluno.projeto.parquimetro.service.InfracaoService;
import com.fiap.aluno.projeto.parquimetro.service.VeiculoService;
import com.fiap.aluno.projeto.parquimetro.service.VerificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class VerificacaoServiceImpl implements VerificacaoService {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private InfracaoService infracaoService;


    @Override
    public String verifica(String placa, String cep) {
        LocalDateTime horaDaVerificacao = LocalDateTime.now();

        Veiculo veiculo = this.veiculoService.obterPorPlaca(placa);

        LocalDateTime horaDaCompraDoBilhete = veiculo.getUltimoBilheteValido().getBilheteCompradoEm();
        Long horasCompradas = Long.valueOf(veiculo.getUltimoBilheteValido().getQuantidadeDeHorasAdquiridas());

        LocalDateTime vencimentoBilhete = horaDaCompraDoBilhete.plusHours(horasCompradas);

        System.out.println("vencimento do bilhete é: " + vencimentoBilhete);

        if(vencimentoBilhete.isBefore(horaDaVerificacao)){
            String msg = "Veículo irregular, multa emitida";


            LocalDateTime de = LocalDate.now().atTime(0, 0);
            LocalDateTime ate = LocalDate.now().atTime(23, 59);

            Infracao infracaoNoDia = this.infracaoService.obterInfracoesNoDiaECepPorPlaca(cep, placa, de, ate);

            if(infracaoNoDia == null){
                Veiculo veiculo1 = new Veiculo();
                veiculo1.setPlaca(placa);


                Infracao infracao = new Infracao();
                infracao.setVeiculo(veiculo1);
                infracao.setValorDaMulta(99.0);
                infracao.setCepDoLocalDaInfracao(cep);

                this.infracaoService.criar(infracao);

                return msg;

            } else {
                return "veiculo com multa já atrelada neste mesmo cep e dia";
            }


        } else {
            // nao emite multa
            String msg = "Veículo regular";
            return msg;
        }
    }
}
