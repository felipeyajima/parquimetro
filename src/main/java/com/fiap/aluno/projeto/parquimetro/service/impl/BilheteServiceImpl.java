package com.fiap.aluno.projeto.parquimetro.service.impl;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import com.fiap.aluno.projeto.parquimetro.repository.BilheteRepository;
import com.fiap.aluno.projeto.parquimetro.repository.VeiculoRepository;
import com.fiap.aluno.projeto.parquimetro.service.BilheteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BilheteServiceImpl implements BilheteService {

    //A Classe MongoTemplate fornecida pelo Spring Data (Extensao do Spring Framework), projetada para fazer a simplificação e integração do Java com o MongoDB
    // obriga a criação do construtor
    private final MongoTemplate mongoTemplate;
    public BilheteServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Autowired
    private BilheteRepository bilheteRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private VeiculoServiceImpl veiculoService;


    @Override
    public List<Bilhete> obterTodos() {
        return this.bilheteRepository.findAll();
    }

    @Override
    public Bilhete obterPorCodigo(String codigo) {

        return this.bilheteRepository
                .findById(codigo)
                .orElseThrow(()-> new IllegalArgumentException("bilhete não existe"));
    }

    @Override
    public Bilhete criar(Bilhete bilhete) {

        boolean veiculoExistente;
        // Procura o veiculo pela placa
        Veiculo veiculo = this.veiculoRepository
                .findByPlaca(bilhete.getVeiculo().getPlaca());

        if(veiculo != null){
            // se o retorno acima for um veiculo existente, atrele ao bilhete
            //veiculoExistente = true;
            bilhete.setVeiculo(veiculo);

        } else {
            //veiculoExistente = false;
            // senao, crie um veiculo pois nao atualizamos com as informacoes atualizadas do departamento de transito para veiculo novos
            Veiculo veiculo1 = new Veiculo();
            veiculo1.setPlaca(bilhete.getVeiculo().getPlaca());
            this.veiculoService.criar(veiculo1);
        }


        Bilhete obj = this.bilheteRepository.save(bilhete);

        //String IdBilhete = bilhete.getCodigo();
        Veiculo veiculo2 = this.veiculoRepository
                .findByPlaca(bilhete.getVeiculo().getPlaca());
        veiculo2.setUltimoBilheteValido(bilhete);
        this.veiculoService.criar(veiculo2);


        return obj;
    }

    @Override
    public void atualizar(Bilhete updateBilhete){
        this.bilheteRepository.save(updateBilhete);
    }

    @Override
    public void deleteById(String codigo){
        Query query = new Query(Criteria.where("codigo").is(codigo));
        mongoTemplate.remove(query, Bilhete.class);
    }

    // estamos utilizando uma nova forma de consulta utilizando Query Methods
    @Override
    public Bilhete findByVeiculoPlacaAndBilheteCompradoEmGreaterThan(String placa, LocalDateTime data){
        return this.bilheteRepository.findByVeiculoPlacaAndBilheteCompradoEmGreaterThan(placa, data);
    }

    @Override
    public List<Bilhete> obterBilhetesPrestesAExpirar(LocalDateTime de, LocalDateTime ate){
        return this.bilheteRepository.obterBilhetesPrestesAExpirar(de, ate);
    }


}
