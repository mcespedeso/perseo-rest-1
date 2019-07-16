package py.com.ideasweb.perseo.stock.services;

import java.util.List;

import py.com.ideasweb.perseo.stock.dtos.ArticuloDepositoDTO;

public interface ArticuloDepositoService {
    
    ArticuloDepositoDTO getByID(Integer idArticuloDeposito) throws Exception;
    
    ArticuloDepositoDTO grabar(ArticuloDepositoDTO dto) throws Exception;
    

    List<ArticuloDepositoDTO> getBySucursalAndDeposito(Integer idSucursal,
            Integer idDeposito, Boolean all) throws Exception;

    List<ArticuloDepositoDTO> getBySucursalAndDepositoByParams(
            Integer idSucursal, Integer idDeposito, String param)
            throws Exception;

    ArticuloDepositoDTO getByArticuloAndDeposito(Integer idArticulo,
            Integer idDeposito) throws Exception;
    
    
    List<ArticuloDepositoDTO>  getByEmpresa(Integer idEmpresa) throws Exception;


}
