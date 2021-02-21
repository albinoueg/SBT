package br.com.albinomoreira.sbt.dao;

import br.com.albinomoreira.sbt.domain.Cidade;

import java.util.List;

public interface CidadeDao {

    void save(Cidade cidade);

    void update(Cidade cidade);

    void delete(Long id);

    Cidade findById(Long id);

    List<Cidade> findAll();
}
