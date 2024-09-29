package com.fiap.aluno.projeto.parquimetro.repository;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {

    @Query("{ 'placa' : ?0 }")
    Veiculo findByPlaca(String placa);

    Page<Veiculo> findAll(Pageable pageable);

    //public void deleteById(String placa);

}
