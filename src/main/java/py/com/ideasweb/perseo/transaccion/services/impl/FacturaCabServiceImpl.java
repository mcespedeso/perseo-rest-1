package py.com.ideasweb.perseo.transaccion.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaCabDTO;
import py.com.ideasweb.perseo.transaccion.mapper.FacturaCabMapper;
import py.com.ideasweb.perseo.transaccion.repositories.FacturaCabRepository;
import py.com.ideasweb.perseo.transaccion.services.FacturaCabService;

@Service
public class FacturaCabServiceImpl extends BaseServiceImpl
        implements FacturaCabService {

    @Autowired
    FacturaCabMapper mapper;

    @Autowired
    FacturaCabRepository repo;

    @Override
    public List<FacturaCabDTO> getBySucursal(Boolean allEstados, Boolean estado,
            Boolean allTipos, Integer idtipofactura, Integer idSucursal)
            throws Exception {
        // TODO Auto-generated method stub
        List<FacturaCabDTO> list = new ArrayList<>();
        if (allEstados) {
            list = mapper.entityListToDtoList(
                    repo.findBySucursalIdSucursal(idSucursal));
        } else {
            list = mapper.entityListToDtoList(
                    repo.findBySucursalIdSucursalAndEstado(idSucursal, estado));
        }

        if (!allTipos)
            return list.stream().filter(
                    f -> f.getTipoFactura().getIdTipoFactura() == idtipofactura)
                    .collect(Collectors.toList());

        return list;
    }

    @Override
    public List<FacturaCabDTO> getByCliente(Integer idcliente, Boolean all,
            Boolean estado) throws Exception {
        // TODO Auto-generated method stub
        if (all) {
            return mapper.entityListToDtoList(
                    repo.findByClienteIdCliente(idcliente));
        } else {
            return mapper.entityListToDtoList(
                    repo.findByClienteIdClienteAndEstado(idcliente, estado));
        }
    }

    @Override
    public FacturaCabDTO cobrarFactura(Integer idfacturacab,
            UsuarioDTO usuarioDTO) throws Exception {
        // TODO Auto-generated method stub
        FacturaCabDTO factura = getById(idfacturacab);
        factura.setEstado(true);
        factura.setFecha(new Date(System.currentTimeMillis()));

        return grabar(factura);
    }

    @Override
    public List<FacturaCabDTO> getByturno(Integer idturno) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findByTurnoIdTurno(idturno));
    }

    @Override
    public FacturaCabDTO grabar(FacturaCabDTO factura) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(factura)));
    }

    @Override
    public FacturaCabDTO getById(Integer idFacturaCab) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idFacturaCab).get());
    }

}
