package com.fiap.aluno.projeto.parquimetro.service;


import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VeiculoService {

    Page<Veiculo> findAll(Pageable pageable);

    public Veiculo criar(Veiculo veiculo);
    public Veiculo obterPorPlaca(String placa);

    public void atualizar(Veiculo veiculo);

    public void deleteById(String placa);

}
