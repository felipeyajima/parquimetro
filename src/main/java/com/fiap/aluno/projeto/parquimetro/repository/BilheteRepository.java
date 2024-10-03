package com.fiap.aluno.projeto.parquimetro.repository;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BilheteRepository extends MongoRepository<Bilhete, String> {

    // Usando métodos pre definidos do Spring data Mongodb
    public void deleteById(String id);

    // QUERY METHOD
    // Convençao utilizada em queries personalizadas
    // estamos utilizando uma nova forma de consulta utilizando Query Methods
    // o springdata se encarrega de entender o nome do metodo e executar a query no mongodb
    public Bilhete findByVeiculoPlacaAndBilheteCompradoEmGreaterThan(String placa, LocalDateTime data);


    // @QUERY
    // caso vc precise fazer consultas mais complexas e personaliza-las
    // query igual do mongodb pelo spring data
    @Query("{ $and: [ {'bilheteCompradoEm': { $gte: ?0}}, {'bilheteCompradoEm': { $lte: ?1}} ] }")
    public List<Bilhete> obterBilhetesPrestesAExpirar(LocalDateTime de, LocalDateTime ate);


    Page<Bilhete> findAll(Pageable pageable);

    public List<Bilhete> findByCpfDoClienteOrderByBilheteCompradoEmAsc(String cpfDoCliente);



}
