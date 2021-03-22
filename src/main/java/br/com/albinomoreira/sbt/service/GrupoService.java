package br.com.albinomoreira.sbt.service;

import br.com.albinomoreira.sbt.domain.GrupoLancamento;

import java.util.List;

public interface GrupoService {
    void salvar(GrupoLancamento grupo);

    void editar(GrupoLancamento grupo);

    void excluir(Long id);

    GrupoLancamento buscarPorId(Long id);

    List<GrupoLancamento> buscarTodos();

    boolean grupoTemLancamento(Long id);
}
