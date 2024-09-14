package com.fiap.aluno.projeto.parquimetro.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Bilhete {
    @Id
    private String codigo;

    @DBRef // permite a referencia de uma collection dentro da outra
    private Veiculo veiculo;
    private LocalDateTime bilheteCompradoEm;
    private int quatidadeDeHorasAdquiridas;
    private String cpfDoCliente;
    private String numeroDeTelefoneDoCliente;

}
