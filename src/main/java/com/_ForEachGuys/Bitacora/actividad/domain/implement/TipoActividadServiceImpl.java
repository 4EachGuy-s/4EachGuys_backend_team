package com._ForEachGuys.Bitacora.actividad.domain.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.actividad.application.service.ITipoActividadService;
import com._ForEachGuys.Bitacora.actividad.infrastructure.repository.TipoActividadRepository;
import com._ForEachGuys.Bitacora.shared.domain.entity.TipoActividad;

@Service
public class TipoActividadServiceImpl implements ITipoActividadService {
    @Autowired
    private TipoActividadRepository tipoActividadRepository;

    @Override
    public List<TipoActividad> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<TipoActividad> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public TipoActividad save(TipoActividad tipoActividad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public TipoActividad update(TipoActividad tipoActividad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}