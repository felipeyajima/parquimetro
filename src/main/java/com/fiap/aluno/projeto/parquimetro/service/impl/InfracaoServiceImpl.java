package com.fiap.aluno.projeto.parquimetro.service.impl;

import com.fiap.aluno.projeto.parquimetro.controller.exception.ControllerNotFoundException;
import com.fiap.aluno.projeto.parquimetro.model.Infracao;
import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import com.fiap.aluno.projeto.parquimetro.repository.InfracaoRepository;
import com.fiap.aluno.projeto.parquimetro.service.InfracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InfracaoServiceImpl implements InfracaoService {

    private final MongoTemplate mongoTemplate;
    public InfracaoServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Autowired
    private InfracaoRepository infracaoRepository;

    @Override
    public Page<Infracao> findAll(Pageable pageable) {
        return this.infracaoRepository.findAll(pageable);
    }

    @Override
    public Infracao criar(Infracao infracao) {

        infracao.setHoraDaOcorrencia(LocalDateTime.now());

        return this.infracaoRepository.save(infracao);
    }

    @Override
    public Infracao obterPorCodigo(String codigo) {
        return this.infracaoRepository
                .findById(codigo)
                .orElseThrow(()-> new ControllerNotFoundException("Infracao não existe"));
    }

    @Override
    public void atualizar(Infracao updatedInfracao) {
        this.infracaoRepository.save(updatedInfracao);
    }

    @Override
    public void deleteById(String codigo) {
        Query query = new Query(Criteria.where("codigo").is(codigo));
        mongoTemplate.remove(query, Infracao.class);
    }

    @Override
    public Infracao obterInfracoesNoDiaECepPorPlaca(String cep, String placa, LocalDateTime de, LocalDateTime ate){

        return this.infracaoRepository.obterInfracoesNoDiaECepPorPlaca(cep, placa, de, ate);
    }


}
