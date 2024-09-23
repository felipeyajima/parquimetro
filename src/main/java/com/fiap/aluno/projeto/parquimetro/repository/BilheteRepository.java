package com.fiap.aluno.projeto.parquimetro.repository;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BilheteRepository extends MongoRepository<Bilhete, String> {

    public void deleteById(String id);

}
