package br.com.albinomoreira.sbt.dao;

import br.com.albinomoreira.sbt.domain.Estado;

import java.util.List;

public interface EstadoDao {

    void save(Estado estado);

    void update(Estado estado);

    void delete(Long id);

    Estado findById(Long id);

    List<Estado> findAll();
}
