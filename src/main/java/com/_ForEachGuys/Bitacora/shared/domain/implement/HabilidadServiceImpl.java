package com._ForEachGuys.Bitacora.shared.domain.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com._ForEachGuys.Bitacora.shared.application.service.IHabilidadService;
import com._ForEachGuys.Bitacora.shared.domain.entity.Habilidad;
import com._ForEachGuys.Bitacora.shared.infrastructure.repository.HabilidadRepository;

public class HabilidadServiceImpl implements IHabilidadService {
    @Autowired
    private HabilidadRepository habilidadRepository;

    @Override
    public List<Habilidad> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Habilidad> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Habilidad save(Habilidad habilidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Habilidad update(Habilidad habilidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}
