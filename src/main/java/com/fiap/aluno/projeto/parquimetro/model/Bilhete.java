package com.fiap.aluno.projeto.parquimetro.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codigo") /// evita o loop infinito
@Data
public class Bilhete {
    @Id
    private String codigo;
    //@JsonManagedReference

    @DBRef // permite a referencia de uma collection dentro da outra
    private Veiculo veiculo;
    private LocalDateTime bilheteCompradoEm;
    private int quantidadeDeHorasAdquiridas;
    private String cpfDoCliente;
    private String numeroDeTelefoneDoCliente;

}
