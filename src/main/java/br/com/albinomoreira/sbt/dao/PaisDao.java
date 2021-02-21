package br.com.albinomoreira.sbt.dao;

import br.com.albinomoreira.sbt.domain.Pais;

import java.util.List;

public interface PaisDao {

    void save(Pais departamento);

    void update(Pais departamento);

    void delete(Long id);

    Pais findById(Long id);

    List<Pais> findAll();
}
