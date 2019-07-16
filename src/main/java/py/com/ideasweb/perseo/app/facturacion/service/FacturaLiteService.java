package py.com.ideasweb.perseo.app.facturacion.service;

import java.util.List;

import py.com.ideasweb.perseo.app.facturacion.model.FacturaLitecab;

public interface FacturaLiteService {

    public void addFacturas(List<FacturaLitecab> facturas) throws Exception;
    
    public void addFactura(FacturaLitecab facturas) throws Exception;

    public List<FacturaLitecab> getFacturas(String apiKey, Integer limit)
            throws Exception;

    public List<FacturaLitecab> getFacturasByEmpresa(Integer idEmpresa,
            String fechadesde, String fechahasta) throws Exception;

    public List<FacturaLitecab> getFacturasByUsuario(Integer idUsuario,
            Integer limit) throws Exception;
}
