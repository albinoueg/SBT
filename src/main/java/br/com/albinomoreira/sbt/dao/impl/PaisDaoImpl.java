package br.com.albinomoreira.sbt.dao.impl;

import br.com.albinomoreira.sbt.dao.AbstractDao;
import br.com.albinomoreira.sbt.dao.PaisDao;
import br.com.albinomoreira.sbt.domain.Pais;
import org.springframework.stereotype.Repository;

@Repository
public class PaisDaoImpl extends AbstractDao<Pais, Long> implements PaisDao {

}
