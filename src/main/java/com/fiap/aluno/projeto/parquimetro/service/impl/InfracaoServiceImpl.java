package com.fiap.aluno.projeto.parquimetro.service.impl;

import com.fiap.aluno.projeto.parquimetro.model.Infracao;
import com.fiap.aluno.projeto.parquimetro.repository.InfracaoRepository;
import com.fiap.aluno.projeto.parquimetro.service.InfracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InfracaoServiceImpl implements InfracaoService {

    @Autowired
    private InfracaoRepository infracaoRepository;

    @Override
    public List<Infracao> obterTodos() {
        return this.infracaoRepository.findAll();
    }

    @Override
    public Infracao obterPorCodigo(String codigo) {
        return this.infracaoRepository
                .findById(codigo)
                .orElseThrow(()-> new IllegalArgumentException("Infracao não existe"));
    }

    @Override
    public Infracao criar(Infracao infracao) {
        return this.infracaoRepository.save(infracao);
    }
}
