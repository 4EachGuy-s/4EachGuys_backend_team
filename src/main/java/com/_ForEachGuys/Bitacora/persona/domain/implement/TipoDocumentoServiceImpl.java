package com._ForEachGuys.Bitacora.persona.domain.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.persona.application.service.ITipoDocumentoService;
import com._ForEachGuys.Bitacora.shared.domain.entity.TipoDocumento;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {
    @Autowired
    private TipoDocumento tipoDocumento;


    @Override
    public List<TipoDocumento> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<TipoDocumento> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public TipoDocumento save(TipoDocumento tipoDocumento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public TipoDocumento update(TipoDocumento tipoDocumento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}