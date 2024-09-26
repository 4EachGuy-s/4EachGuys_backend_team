package com._ForEachGuys.Bitacora.shared.domain.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.shared.application.service.IEstadoService;
import com._ForEachGuys.Bitacora.shared.domain.entity.Estado;
import com._ForEachGuys.Bitacora.shared.infrastructure.repository.EstadoRepository;

@Service
public class EstadoServiceImpl implements IEstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Estado> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Estado save(Estado estado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Estado update(Estado estado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}