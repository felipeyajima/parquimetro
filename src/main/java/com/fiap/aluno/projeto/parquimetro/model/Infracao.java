package com.fiap.aluno.projeto.parquimetro.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
@Data
public class Infracao {
    @Id
    private String codigo;
    private LocalDateTime horaDaOcorrencia;

    @DBRef // permite a referencia de uma collection dentro da outra
    private Veiculo veiculo;
    private Double valorDaMulta;
    private String cepDoLocalDaInfracao;
}
