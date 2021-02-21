package br.com.albinomoreira.sbt.service;

import br.com.albinomoreira.sbt.domain.Estado;

import java.util.List;

public interface EstadoService {

    void salvar(Estado cargo);

    void editar(Estado cargo);

    void excluir(Long id);

    Estado buscarPorId(Long id);

    List<Estado> buscarTodos();

    boolean estadoTemCidade(Long id);
}
