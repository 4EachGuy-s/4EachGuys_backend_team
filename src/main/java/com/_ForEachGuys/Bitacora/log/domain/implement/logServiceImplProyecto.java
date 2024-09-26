package com._ForEachGuys.Bitacora.log.domain.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.log.application.service.ILogServiceProyecto;
import com._ForEachGuys.Bitacora.log.infrastructure.repository.LogRepositoryProyecto;
import com._ForEachGuys.Bitacora.shared.domain.entity.Proyecto;


@Service
public class logServiceImplProyecto implements  ILogServiceProyecto{
    @Autowired
    private LogRepositoryProyecto logRepositoryProyecto;

    @Override
    public List<Proyecto> findAll() {
        return logRepositoryProyecto.findAll();
    }

    @Override
    public Optional<Proyecto> findById(Long id) {
        return logRepositoryProyecto.findById(id);
    }

    @Override
    public Proyecto save(Proyecto proyecto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Proyecto update(Proyecto proyecto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
