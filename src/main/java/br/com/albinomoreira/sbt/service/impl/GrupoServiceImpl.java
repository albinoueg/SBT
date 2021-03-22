package br.com.albinomoreira.sbt.service.impl;

import br.com.albinomoreira.sbt.dao.GrupoDao;
import br.com.albinomoreira.sbt.domain.GrupoLancamento;
import br.com.albinomoreira.sbt.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    private GrupoDao dao;

    @Transactional(readOnly = false)
    @Override
    public void salvar(GrupoLancamento grupo) {
        dao.save(grupo);
    }

    @Transactional(readOnly = false)
    @Override
    public void editar(GrupoLancamento grupo) {
        dao.update(grupo);
    }

    @Transactional(readOnly = false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public GrupoLancamento buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<GrupoLancamento> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean grupoTemLancamento(Long id) {
        if(buscarPorId(id).getLancamentos().isEmpty()){
            return false;
        }
        return true;
    }

}
