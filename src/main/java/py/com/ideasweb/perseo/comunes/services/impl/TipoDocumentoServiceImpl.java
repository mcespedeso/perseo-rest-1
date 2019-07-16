package py.com.ideasweb.perseo.comunes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.common.constants.WebUtils;
import py.com.ideasweb.perseo.comunes.dtos.TipoDocumentoDTO;
import py.com.ideasweb.perseo.comunes.mapper.TipoDocumentoMapper;
import py.com.ideasweb.perseo.comunes.repositories.TipoDocumentoRepository;
import py.com.ideasweb.perseo.comunes.services.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl extends BaseServiceImpl
        implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private TipoDocumentoMapper tipoDocumentoMapper;

    @Override
    public TipoDocumentoDTO grabarTipoDocumento(
            TipoDocumentoDTO tipoDocumento) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<TipoDocumentoDTO> tipoDocumentoAll(
            TipoDocumentoDTO tipoDocumento) {

        return tipoDocumentoMapper
                .entityListToDtoList(tipoDocumentoRepository.findAll());

    }

    @Override
    public List<TipoDocumentoDTO> findAll() {
        return tipoDocumentoMapper.entityListToDtoList(
                WebUtils.toList(tipoDocumentoRepository.findAll()));
    }

}
