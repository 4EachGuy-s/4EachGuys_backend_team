package com._ForEachGuys.Bitacora.shared.domain.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com._ForEachGuys.Bitacora.shared.application.service.IPrioridadService;
import com._ForEachGuys.Bitacora.shared.domain.entity.Prioridad;
import com._ForEachGuys.Bitacora.shared.infrastructure.repository.PrioridadRepository;

public class PrioridadServiceImpl implements IPrioridadService {
    @Autowired
    private PrioridadRepository prioridadRepository;

    @Override
    public List<Prioridad> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Prioridad> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Prioridad save(Prioridad prioridad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Prioridad update(Prioridad prioridad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}