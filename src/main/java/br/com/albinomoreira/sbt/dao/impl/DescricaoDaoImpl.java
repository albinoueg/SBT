package br.com.albinomoreira.sbt.dao.impl;

import br.com.albinomoreira.sbt.dao.AbstractDao;
import br.com.albinomoreira.sbt.dao.DescricaoDao;
import br.com.albinomoreira.sbt.domain.DescricaoLancamento;
import org.springframework.stereotype.Repository;

@Repository
public class DescricaoDaoImpl extends AbstractDao<DescricaoLancamento, Long> implements DescricaoDao {

}
