package com._ForEachGuys.Bitacora.log.domain.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.log.application.service.ILogServicePersona;
import com._ForEachGuys.Bitacora.log.infrastructure.repository.LogRepositoryPersona;
import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;

@Service
public class logServiceImplPersona implements ILogServicePersona {
    @Autowired
    private LogRepositoryPersona logRepositoryPersona;

    @Override
    public List<Persona> findAll() {
        return logRepositoryPersona.findAll();
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return logRepositoryPersona.findById(id);
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
