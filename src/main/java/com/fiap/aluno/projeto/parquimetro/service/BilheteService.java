package com.fiap.aluno.projeto.parquimetro.service;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;

import java.util.List;

public interface BilheteService {

    public List<Bilhete> obterTodos();
    public Bilhete obterPorCodigo();
    public Bilhete criar();

}
