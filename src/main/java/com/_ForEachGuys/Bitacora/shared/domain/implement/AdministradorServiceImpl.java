package com._ForEachGuys.Bitacora.shared.domain.implement;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com._ForEachGuys.Bitacora.shared.application.service.IAdministradorService;
import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;
import com._ForEachGuys.Bitacora.shared.infrastructure.repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements IAdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public List<Persona> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Persona> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Persona save(Persona persona) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Persona update(Persona persona) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
