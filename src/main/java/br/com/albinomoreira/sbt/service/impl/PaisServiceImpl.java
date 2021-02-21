package br.com.albinomoreira.sbt.service.impl;

import br.com.albinomoreira.sbt.dao.PaisDao;
import br.com.albinomoreira.sbt.domain.Pais;
import br.com.albinomoreira.sbt.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {


    @Autowired
    private PaisDao dao;


    @Transactional(readOnly = false)
    @Override
    public void salvar(Pais pais) {
        dao.save(pais);
    }

    @Transactional(readOnly = false)
    @Override
    public void editar(Pais pais) {
        dao.update(pais);
    }

    @Transactional(readOnly = false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Pais buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pais> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean paisTemEstado(Long id) {
        if(buscarPorId(id).getEstado().isEmpty()){
            return false;
        }
        return true;
    }

}
