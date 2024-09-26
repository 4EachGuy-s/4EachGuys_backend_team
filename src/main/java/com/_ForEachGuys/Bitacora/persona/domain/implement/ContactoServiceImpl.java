package com._ForEachGuys.Bitacora.persona.domain.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.persona.application.service.IContactoService;
import com._ForEachGuys.Bitacora.persona.infrastructure.repository.ContactoRepository;
import com._ForEachGuys.Bitacora.shared.domain.entity.Contacto;

@Service
public class ContactoServiceImpl implements IContactoService {
    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public List<Contacto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Contacto> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Contacto save(Contacto contacto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Contacto update(Contacto contacto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}