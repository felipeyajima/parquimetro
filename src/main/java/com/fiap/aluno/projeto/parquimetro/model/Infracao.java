package com.fiap.aluno.projeto.parquimetro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
public class Infracao {
    @Id
    private String codigo;
    private LocalDateTime horaDaOcorrencia;
    private Veiculo veiculo;
    private Double valorDaMulta;
    private String cepDoLocalDaInfracao;
}
