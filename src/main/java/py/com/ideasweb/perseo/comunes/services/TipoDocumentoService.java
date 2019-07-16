package py.com.ideasweb.perseo.comunes.services;

import java.util.List;

import py.com.ideasweb.perseo.comunes.dtos.TipoDocumentoDTO;

public interface TipoDocumentoService {

    public TipoDocumentoDTO grabarTipoDocumento(TipoDocumentoDTO tipoDocumento);

    List<TipoDocumentoDTO> findAll();
}
