package com.fiap.aluno.projeto.parquimetro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "placa") /// evita o loop infinito
@Data //Estamos fazendo uso do Lombok, permite com que o encapsulamento seja utilizado nessa classe, e de forma invisivel, todos os getters e setters sejam permitidos para uso em relacao as propriedades abaixo
// disponibiliza um get e set para cada uma das propriedas de forma invisivel
public class Veiculo {
    //
    //private String codigo;
    @Id
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private String anoDeFabricacao;
    private String chassi;
    //@JsonBackReference

    @DBRef // permite a referencia de uma collection dentro da outra
    private Bilhete ultimoBilheteValido;
}
