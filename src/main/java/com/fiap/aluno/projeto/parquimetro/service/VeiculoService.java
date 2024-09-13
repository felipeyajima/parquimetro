package com.fiap.aluno.projeto.parquimetro.service;


import com.fiap.aluno.projeto.parquimetro.model.Veiculo;

import java.util.List;

public interface VeiculoService {
    public List<Veiculo> obterTodos();
    public Veiculo obterPorCodigo(String codigo);
    public Veiculo criar(Veiculo veiculo);

}
