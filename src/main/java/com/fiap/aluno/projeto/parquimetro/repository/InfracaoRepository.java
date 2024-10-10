package com.fiap.aluno.projeto.parquimetro.repository;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import com.fiap.aluno.projeto.parquimetro.model.Infracao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface InfracaoRepository extends MongoRepository<Infracao, String> {
    @Query("{ $and: [ {'cepDoLocalDaInfracao': { $eq: ?0}}, {'veiculo.$id': { $eq: ?1}}, {'horaDaOcorrencia': { $gte: ?2}}, {'horaDaOcorrencia': { $lte: ?3}} ] }")
    public Infracao obterInfracoesNoDiaECepPorPlaca(String cep, String placa, LocalDateTime de, LocalDateTime ate);
}
