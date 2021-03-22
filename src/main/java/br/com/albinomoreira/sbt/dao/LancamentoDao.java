package br.com.albinomoreira.sbt.dao;

import br.com.albinomoreira.sbt.domain.Lancamento;

import java.util.List;

public interface LancamentoDao {

    void save(Lancamento lancamento);

    void update(Lancamento lancamento);

    void delete(Long id);

    Lancamento findById(Long id);

    List<Lancamento> findAll();
}
