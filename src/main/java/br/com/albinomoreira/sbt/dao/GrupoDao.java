package br.com.albinomoreira.sbt.dao;

import br.com.albinomoreira.sbt.domain.GrupoLancamento;

import java.util.List;

public interface GrupoDao {

    void save(GrupoLancamento grupo);

    void update(GrupoLancamento grupo);

    void delete(Long id);

    GrupoLancamento findById(Long id);

    List<GrupoLancamento> findAll();
}
