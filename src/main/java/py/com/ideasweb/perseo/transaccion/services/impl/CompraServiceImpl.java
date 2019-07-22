package py.com.ideasweb.perseo.transaccion.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.transaccion.dtos.CompraCabDTO;
import py.com.ideasweb.perseo.transaccion.mapper.CompraCabMapper;
import py.com.ideasweb.perseo.transaccion.mapper.CompraDetMapper;
import py.com.ideasweb.perseo.transaccion.repositories.CompraCabRepository;
import py.com.ideasweb.perseo.transaccion.repositories.CompraDetRepository;
import py.com.ideasweb.perseo.transaccion.services.CompraService;

@Service
public class CompraServiceImpl extends BaseServiceImpl
        implements CompraService {

    @Autowired
    CompraCabRepository repo;

    @Autowired
    CompraDetRepository detRepo;

    @Autowired
    CompraCabMapper mapper;

    @Autowired
    CompraDetMapper detMapper;

    @Override
    public String registrarCompra(CompraCabDTO cab, UsuarioDTO usuario)
            throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CompraCabDTO> getByEmpresaAndFecha(Date fechaDesde,
            Date fechahasta, Integer idEmpresa) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CompraCabDTO> getByProveedorAndFecha(Date fechaDesde,
            Date fechahasta, Integer idProveedor) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getLibroIvaCompra(String datos, UsuarioDTO usuarioDTO)
            throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CompraCabDTO> getByturno(Integer idturno) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
