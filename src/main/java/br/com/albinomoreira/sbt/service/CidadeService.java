package br.com.albinomoreira.sbt.service;

import br.com.albinomoreira.sbt.domain.Cidade;

import java.util.List;

public interface CidadeService {

    void salvar(Cidade cidade);

    void editar(Cidade cidade);

    void excluir(Long id);

    Cidade buscarPorId(Long id);

    List<Cidade> buscarTodos();

}
