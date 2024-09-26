package com._ForEachGuys.Bitacora.actividad.domain.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.actividad.application.service.IActividadService;
import com._ForEachGuys.Bitacora.actividad.infrastructure.repository.ActividadRepository;
import com._ForEachGuys.Bitacora.shared.domain.entity.Actividad;
@Service
public class ActividadServiceImpl implements IActividadService {

    @Autowired
    private ActividadRepository ActividadRepository;

    @Override
    public List<Actividad> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Actividad> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Actividad save(Actividad chapter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Actividad update(Actividad chapter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}