package com.fiap.aluno.projeto.parquimetro.service.impl;

import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import com.fiap.aluno.projeto.parquimetro.repository.BilheteRepository;
import com.fiap.aluno.projeto.parquimetro.repository.VeiculoRepository;
import com.fiap.aluno.projeto.parquimetro.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final MongoTemplate mongoTemplate;
    public VeiculoServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private BilheteRepository bilheteRepository;

    @Override
    public List<Veiculo> obterTodos() {
        return this.veiculoRepository.findAll();
    }

    @Override
    public Veiculo obterPorPlaca(String placa) {
        return this.veiculoRepository
                .findById(placa)
                .orElseThrow(()-> new IllegalArgumentException("Veiculo não existe"));
    }

    @Override
    public Veiculo criar(Veiculo veiculo) {
        return this.veiculoRepository.save(veiculo);
    }

    public void atualizar(Veiculo updateVeiculo){this.veiculoRepository.save(updateVeiculo);}

    @Override
    public void deleteById(String placa){
        Query query = new Query(Criteria.where("placa").is(placa));
        mongoTemplate.remove(query, Veiculo.class);
    }



}
