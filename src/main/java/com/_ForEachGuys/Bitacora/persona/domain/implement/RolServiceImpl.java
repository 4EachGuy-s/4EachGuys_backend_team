package com._ForEachGuys.Bitacora.persona.domain.implement;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com._ForEachGuys.Bitacora.persona.application.service.IRolService;
import com._ForEachGuys.Bitacora.persona.infrastructure.repository.RolRepository;
import com._ForEachGuys.Bitacora.shared.domain.entity.Rol;

@Service
public class RolServiceImpl implements IRolService {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Rol> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Rol save(Rol rol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Rol update(Rol rol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}