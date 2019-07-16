package py.com.ideasweb.perseo.tesoreria.services;

import java.util.List;

import py.com.ideasweb.perseo.tesoreria.dtos.MonedaDTO;

public interface MonedaService {

    MonedaDTO grabar(MonedaDTO moneda) throws Exception;

    List<MonedaDTO> findAll() throws Exception;

    MonedaDTO getByCodMoneda(Integer codMoneda) throws Exception;
}
