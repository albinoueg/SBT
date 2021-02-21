package br.com.albinomoreira.sbt.dao.impl;

import br.com.albinomoreira.sbt.dao.AbstractDao;
import br.com.albinomoreira.sbt.dao.CidadeDao;
import br.com.albinomoreira.sbt.domain.Cidade;
import org.springframework.stereotype.Repository;


@Repository
public class CidadeDaoImpl extends AbstractDao<Cidade, Long> implements CidadeDao {

}
