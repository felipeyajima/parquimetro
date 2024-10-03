package com.fiap.aluno.projeto.parquimetro.service.impl;

import com.fiap.aluno.projeto.parquimetro.controller.exception.ControllerNotFoundException;
import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import com.fiap.aluno.projeto.parquimetro.repository.BilheteRepository;
import com.fiap.aluno.projeto.parquimetro.repository.VeiculoRepository;
import com.fiap.aluno.projeto.parquimetro.service.BilheteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public Page<Bilhete> findAll(Pageable pageable) {
        return this.bilheteRepository.findAll(pageable);
    }

    @Override
    public Bilhete obterPorCodigo(String codigo) {

        return this.bilheteRepository
                .findById(codigo)
                .orElseThrow(()-> new ControllerNotFoundException("bilhete não existe"));
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

        bilhete.setBilheteCompradoEm(LocalDateTime.now());
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

    @Override
    public void compraDeHorasAdicionais(String codigo, int horas) {

        this.bilheteRepository
                .findById(codigo)
                .orElseThrow(()-> new ControllerNotFoundException("bilhete não existe"));

        Optional<Bilhete> bilhete = this.bilheteRepository.findById(codigo);

        if(bilhete != null){
            codigo = bilhete.orElseThrow(RuntimeException::new).getCodigo();
            Veiculo veiculo = bilhete.orElseThrow(RuntimeException::new).getVeiculo();
            LocalDateTime hora = bilhete.orElseThrow(RuntimeException::new).getBilheteCompradoEm();
            String cpf = bilhete.orElseThrow(RuntimeException::new).getCpfDoCliente();
            String numero = bilhete.orElseThrow(RuntimeException::new).getNumeroDeTelefoneDoCliente();

            int horaFinal = bilhete.orElseThrow(RuntimeException::new).getQuantidadeDeHorasAdquiridas() + horas;


            Bilhete obj = new Bilhete();
            obj.setCodigo(codigo);
            obj.setQuantidadeDeHorasAdquiridas(horaFinal);
            obj.setVeiculo(veiculo);
            obj.setBilheteCompradoEm(hora);
            obj.setCpfDoCliente(cpf);
            obj.setNumeroDeTelefoneDoCliente(numero);

            this.bilheteRepository.save(obj);


        } else {
            throw new ControllerNotFoundException("bilhete não existe");
        }
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


    @Override
    public List<Bilhete> findByCpfDoClienteOrderByBilheteCompradoEmAsc(String cpfDoCliente) {
        return this.bilheteRepository.findByCpfDoClienteOrderByBilheteCompradoEmAsc(cpfDoCliente);
    }


    // Usando Pesquisa Dinâmica, muito utilizado no mercado de trabalho
    /*@Override
    public List<Bilhete> encontrarBilhetesPesquisaDinamica(Integer quantidadeDeHorasAdquiridas,
                                                           LocalDateTime data){
        Criteria criteria = new Criteria();
        // filtrar bilhetes igual ao valor fornecido
        criteria.and("bilheteCompradoEm").lte(data);

        if(quantidadeDeHorasAdquiridas !=null){
            criteria.and("quantidadeDeHorasAdquiridas").is(quantidadeDeHorasAdquiridas);
        }

        Query query = new Query(criteria);
        return mongoTemplate.find(query, Bilhete.class);

    }*/



}
