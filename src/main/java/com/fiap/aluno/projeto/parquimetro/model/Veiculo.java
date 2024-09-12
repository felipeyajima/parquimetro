package com.fiap.aluno.projeto.parquimetro.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document


@Data //Estamos fazendo uso do Lombok, permite com que o encapsulamento seja utilizado nessa classe, e de forma invisivel, todos os getters e setters sejam permitidos para uso em relacao as propriedades abaixo
// disponibiliza um get e set para cada uma das propriedas de forma invisivel
public class Veiculo {
    @Id
    private String codigo;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private String anoDeFabricacao;
    private String chassi;
    private Bilhete ultimoBilheteValido;
}
