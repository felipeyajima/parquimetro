package com.fiap.aluno.projeto.parquimetro.service;

import com.fiap.aluno.projeto.parquimetro.model.Bilhete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface BilheteService {

    Page<Bilhete> findAll(Pageable pageable);
    public Bilhete obterPorCodigo(String codigo);
    public Bilhete criar(Bilhete bilhete);

    public void atualizar(Bilhete bilhete);

    public void deleteById(String codigo);

    public Bilhete findByVeiculoPlacaAndBilheteCompradoEmGreaterThan(String placa, LocalDateTime data);

    public List<Bilhete> obterBilhetesPrestesAExpirar(LocalDateTime de, LocalDateTime ate);

    public List<Bilhete> findByCpfDoClienteOrderByBilheteCompradoEmAsc(String cpfDoCliente);

    //public List<Bilhete> encontrarBilhetesPesquisaDinamica(Integer quantidadeDeHorasAdquiridas,
    //                                                       LocalDateTime data);
}
