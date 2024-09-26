package com._ForEachGuys.Bitacora.log.domain.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.log.application.service.ILogServiceActividad;
import com._ForEachGuys.Bitacora.log.infrastructure.repository.LogRepositoryActividad;
import com._ForEachGuys.Bitacora.shared.domain.entity.Actividad;

@Service
public class logServiceImplActividad implements ILogServiceActividad{

    @Autowired
    private LogRepositoryActividad logRepositoryActividad;

    @Override
    public List<Actividad> findAll() {
        return logRepositoryActividad.findAll();
    }

    @Override
    public Optional<Actividad> findById(Long id) {
        return logRepositoryActividad.findById(id);
    }

    @Override
    public Actividad save(Actividad actividad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Actividad update(Actividad actividad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}
