package br.com.albinomoreira.sbt.service;

import br.com.albinomoreira.sbt.domain.Pais;

import java.util.List;

public interface PaisService {
    void salvar(Pais pais);

    void editar(Pais pais);

    void excluir(Long id);

    Pais buscarPorId(Long id);

    List<Pais> buscarTodos();

    boolean paisTemEstado(Long id);
}
