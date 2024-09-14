package com.fiap.aluno.projeto.parquimetro.service.impl;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import com.fiap.aluno.projeto.parquimetro.repository.BilheteRepository;
import com.fiap.aluno.projeto.parquimetro.service.BilheteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilheteServiceImpl implements BilheteService {

    @Autowired
    private BilheteRepository bilheteRepository;

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

        return this.bilheteRepository.save(bilhete);
    }
}
