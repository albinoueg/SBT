package br.com.albinomoreira.sbt.dao;

import br.com.albinomoreira.sbt.domain.DescricaoLancamento;

import java.util.List;

public interface DescricaoDao {

    void save(DescricaoLancamento descricao);

    void update(DescricaoLancamento descricao);

    void delete(Long id);

    DescricaoLancamento findById(Long id);

    List<DescricaoLancamento> findAll();
}
