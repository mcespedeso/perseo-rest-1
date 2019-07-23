package py.com.ideasweb.perseo.transaccion.services;

import java.util.List;

import py.com.ideasweb.perseo.transaccion.dtos.VentaDetDTO;

public interface VentaDetService {

    VentaDetDTO grabar(VentaDetDTO dto) throws Exception;

    List<VentaDetDTO> getByVentaCab(Integer idVentaCab) throws Exception;
}
