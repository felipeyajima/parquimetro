package com.fiap.aluno.projeto.parquimetro.service;

import com.fiap.aluno.projeto.parquimetro.model.Infracao;
import com.fiap.aluno.projeto.parquimetro.model.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface InfracaoService {

    Page<Infracao> findAll(Pageable pageable);

    public Infracao criar(Infracao infracao);

    public Infracao obterPorCodigo(String codigo);

    public void atualizar(Infracao infracao);

    public void deleteById(String codigo);

    public Infracao obterInfracoesNoDiaECepPorPlaca(String cep, String placa, LocalDateTime de, LocalDateTime ate);


}
