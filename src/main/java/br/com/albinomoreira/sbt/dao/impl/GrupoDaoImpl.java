package br.com.albinomoreira.sbt.dao.impl;

import br.com.albinomoreira.sbt.dao.AbstractDao;
import br.com.albinomoreira.sbt.dao.GrupoDao;
import br.com.albinomoreira.sbt.domain.GrupoLancamento;
import org.springframework.stereotype.Repository;

@Repository
public class GrupoDaoImpl extends AbstractDao<GrupoLancamento, Long> implements GrupoDao {

}
