package py.com.ideasweb.perseo.transaccion.services;

import java.util.List;

import py.com.ideasweb.perseo.transaccion.dtos.CompraCabDTO;

public interface CompraCabService {

     List<CompraCabDTO> getByturno(Integer idturno) throws Exception;
}
