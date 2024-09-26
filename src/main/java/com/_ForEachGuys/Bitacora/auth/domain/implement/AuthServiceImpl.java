package com._ForEachGuys.Bitacora.auth.domain.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.auth.application.service.IAuthServic;
import com._ForEachGuys.Bitacora.auth.infrastructure.repository.AuthRepository;
import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;

@Service
public class AuthServiceImpl implements IAuthServic {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public List<Persona> findAll() {
        return authRepository.findAll();
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return authRepository.findById(id);
    }

    @Override
    /*FALTA LOS GET PARA IMPLEMENTAR */
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
    public void deletedById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletedById'");
    }
    
}
