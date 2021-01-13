package br.com.albinomoreira.sbt.dao.impl;

import br.com.albinomoreira.sbt.dao.AbstractDao;
import br.com.albinomoreira.sbt.dao.CargoDao;
import br.com.albinomoreira.sbt.domain.Cargo;
import org.springframework.stereotype.Repository;


@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

}
