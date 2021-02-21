package br.com.albinomoreira.sbt.dao.impl;

import br.com.albinomoreira.sbt.dao.AbstractDao;
import br.com.albinomoreira.sbt.dao.EstadoDao;
import br.com.albinomoreira.sbt.domain.Estado;
import org.springframework.stereotype.Repository;


@Repository
public class EstadoDaoImpl extends AbstractDao<Estado, Long> implements EstadoDao {

}
