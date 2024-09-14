package com.fiap.aluno.projeto.parquimetro.service.impl;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import com.fiap.aluno.projeto.parquimetro.repository.BilheteRepository;
import com.fiap.aluno.projeto.parquimetro.repository.VeiculoRepository;
import com.fiap.aluno.projeto.parquimetro.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;


    //@Autowired
    //private BilheteRepository bilheteRepository;

    @Override
    public List<Veiculo> obterTodos() {
        return this.veiculoRepository.findAll();
    }

    @Override
    public Veiculo obterPorCodigo(String codigo) {
        return this.veiculoRepository
                .findById(codigo)
                .orElseThrow(()-> new IllegalArgumentException("Veiculo não existe"));
    }

    @Override
    public Veiculo criar(Veiculo veiculo) {
        return this.veiculoRepository.save(veiculo);
    }



    @Override
    public Veiculo obterPorPlaca(String placa){
        return this.veiculoRepository.findByPlaca(placa);
    }




}
