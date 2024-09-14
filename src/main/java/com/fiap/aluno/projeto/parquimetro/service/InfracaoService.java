package com.fiap.aluno.projeto.parquimetro.service;

import com.fiap.aluno.projeto.parquimetro.model.Infracao;

import java.util.List;

public interface InfracaoService {

    public List<Infracao>  obterTodos();
    public Infracao obterPorCodigo(String codigo);
    public Infracao criar(Infracao infracao);
}
