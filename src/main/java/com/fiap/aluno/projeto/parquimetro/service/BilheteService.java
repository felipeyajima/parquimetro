package com.fiap.aluno.projeto.parquimetro.service;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;

import java.time.LocalDateTime;
import java.util.List;

public interface BilheteService {

    public List<Bilhete> obterTodos();
    public Bilhete obterPorCodigo(String codigo);
    public Bilhete criar(Bilhete bilhete);

    public void atualizar(Bilhete bilhete);

    public void deleteById(String codigo);

    public Bilhete findByVeiculoPlacaAndBilheteCompradoEmGreaterThan(String placa, LocalDateTime data);

    public List<Bilhete> obterBilhetesPrestesAExpirar(LocalDateTime de, LocalDateTime ate);
}
