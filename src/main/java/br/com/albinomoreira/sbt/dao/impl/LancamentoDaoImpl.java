package br.com.albinomoreira.sbt.dao.impl;

import br.com.albinomoreira.sbt.dao.AbstractDao;
import br.com.albinomoreira.sbt.dao.LancamentoDao;
import br.com.albinomoreira.sbt.domain.Lancamento;
import org.springframework.stereotype.Repository;

@Repository
public class LancamentoDaoImpl extends AbstractDao<Lancamento, Long> implements LancamentoDao {

}
