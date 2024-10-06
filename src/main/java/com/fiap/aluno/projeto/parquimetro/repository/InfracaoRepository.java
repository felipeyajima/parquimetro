package com.fiap.aluno.projeto.parquimetro.repository;

import com.fiap.aluno.projeto.parquimetro.model.Infracao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InfracaoRepository extends MongoRepository<Infracao, String> {

}
