package com._ForEachGuys.Bitacora.shared.domain.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.shared.application.service.ITipoHabilidadservice;
import com._ForEachGuys.Bitacora.shared.domain.entity.TipoHabilidad;
import com._ForEachGuys.Bitacora.shared.infrastructure.repository.TipoHabilidadRepository;

@Service
public class TipoHabilidadServiceImpl implements ITipoHabilidadservice {
    @Autowired
    private TipoHabilidadRepository tipoHabilidadRepository;


    @Override
    public List<TipoHabilidad> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<TipoHabilidad> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public TipoHabilidad save(TipoHabilidad tipoHabilidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public TipoHabilidad update(TipoHabilidad tipoHabilidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}