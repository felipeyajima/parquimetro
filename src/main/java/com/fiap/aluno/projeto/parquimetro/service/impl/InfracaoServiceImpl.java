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
        return null;
    }

    @Override
    public Infracao obterPorCodigo() {
        return null;
    }

    @Override
    public Infracao criar() {
        return null;
    }
}
