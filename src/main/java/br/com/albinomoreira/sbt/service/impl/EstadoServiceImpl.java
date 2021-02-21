package br.com.albinomoreira.sbt.service.impl;

import br.com.albinomoreira.sbt.dao.CargoDao;
import br.com.albinomoreira.sbt.dao.EstadoDao;
import br.com.albinomoreira.sbt.domain.Cargo;
import br.com.albinomoreira.sbt.domain.Estado;
import br.com.albinomoreira.sbt.service.CargoService;
import br.com.albinomoreira.sbt.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoDao dao;

    @Override
    public void salvar(Estado estado) {
        dao.save(estado);
    }

    @Override
    public void editar(Estado estado) {
        dao.update(estado);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Estado buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Estado> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean estadoTemCidade(Long id) {
        if (buscarPorId(id).getCidade().isEmpty()) {
            return false;
        }
        return true;
    }
}
