package com.fiap.aluno.projeto.parquimetro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Bilhete {
    @Id
    private String codigo;
    private Veiculo veiculo;
    private LocalDateTime bilheteCompradoEm;
    private int quatidadeDeHorasAdquiridas;
    private String cpfDoCliente;
    private String numeroDeTelefoneDoCliente;

}
