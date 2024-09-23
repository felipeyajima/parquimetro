package com.fiap.aluno.projeto.parquimetro.service;


import com.fiap.aluno.projeto.parquimetro.model.Veiculo;

import java.util.List;

public interface VeiculoService {
    public List<Veiculo> obterTodos();
    public Veiculo criar(Veiculo veiculo);
    public Veiculo obterPorPlaca(String placa);

    public void atualizar(Veiculo veiculo);

    public void deleteById(String placa);

}
