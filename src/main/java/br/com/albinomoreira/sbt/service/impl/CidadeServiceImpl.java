package br.com.albinomoreira.sbt.service.impl;

import br.com.albinomoreira.sbt.dao.CidadeDao;
import br.com.albinomoreira.sbt.domain.Cidade;
import br.com.albinomoreira.sbt.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeDao dao;

    @Override
    public void salvar(Cidade cidade) {
        dao.save(cidade);
    }

    @Override
    public void editar(Cidade cidade) {
        dao.update(cidade);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cidade buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cidade> buscarTodos() {
        return dao.findAll();
    }

}
