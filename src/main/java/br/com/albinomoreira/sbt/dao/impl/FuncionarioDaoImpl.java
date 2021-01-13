package br.com.albinomoreira.sbt.dao.impl;

import br.com.albinomoreira.sbt.dao.AbstractDao;
import br.com.albinomoreira.sbt.dao.FuncionarioDao;
import br.com.albinomoreira.sbt.domain.Funcionario;
import org.springframework.stereotype.Repository;


@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}
