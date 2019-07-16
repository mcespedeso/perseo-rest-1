package py.com.ideasweb.perseo.transaccion.services;

import java.util.List;

import py.com.ideasweb.perseo.transaccion.dtos.FormaPagoDTO;

public interface FormaPagoService {

    FormaPagoDTO grabar(FormaPagoDTO dto) throws Exception;

    List<FormaPagoDTO> findAll() throws Exception;

    FormaPagoDTO getById(Integer idFormaPago) throws Exception;
}
