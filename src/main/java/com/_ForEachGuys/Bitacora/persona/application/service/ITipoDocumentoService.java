package com._ForEachGuys.Bitacora.persona.application.service;

import java.util.List;
import java.util.Optional;
import com._ForEachGuys.Bitacora.shared.domain.entity.TipoDocumento;

public interface ITipoDocumentoService {
    List<TipoDocumento> findAll();
    Optional<TipoDocumento> findById(Long id);
    TipoDocumento save(TipoDocumento tipoDocumento);
    TipoDocumento update(TipoDocumento tipoDocumento);
    void deleteById(Long id);
}