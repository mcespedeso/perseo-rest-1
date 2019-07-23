package py.com.ideasweb.perseo.transaccion.services.impl;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.tesoreria.dtos.MonedaDTO;
import py.com.ideasweb.perseo.transaccion.dtos.EstadoVentaDTO;
import py.com.ideasweb.perseo.transaccion.dtos.VentaCabDTO;
import py.com.ideasweb.perseo.transaccion.mapper.VentaCabMapper;
import py.com.ideasweb.perseo.transaccion.repositories.VentaCabRepository;
import py.com.ideasweb.perseo.transaccion.services.VentaCabService;
import py.com.ideasweb.perseo.transaccion.services.VentaDetService;

@Service
public class VentaCabServiceImpl extends BaseServiceImpl
        implements VentaCabService {

    @Autowired
    VentaCabRepository repo;

    @Autowired
    VentaCabMapper mapper;

    @Autowired
    VentaDetService ventaDetService;

    @Override
    public VentaCabDTO getById(Integer idVentaCab) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.getOne(idVentaCab));
    }

    @Override
    public VentaCabDTO grabar(VentaCabDTO dto) throws Exception {
        // TODO Auto-generated method stub
        VentaCabDTO newVentaCab = mapper
                .entityToDto(repo.save(mapper.dtoToEntity(dto)));
        // insertar detalles
        dto.getDetalles().stream().forEach(d -> {
            try {
                d.setVentaCab(newVentaCab);
                ventaDetService.grabar(d);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        return newVentaCab;
    }

    @Override
    public List<VentaCabDTO> findByEmpresaAndFechas(Integer idEmpresa,
            Date fechadesde, Date fechaHasta) throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresaAndFechaBetween(
                        idEmpresa, fechadesde, fechaHasta))
                .stream().peek(v -> {
                    try {
                        ventaDetService.getByVentaCab(v.getIdVentaCab());
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }).collect(Collectors.toList());
    }

    @Override
    public List<VentaCabDTO> getByEstadoAndSucursal(Integer estado,
            Integer idSucursal) throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findBySucursalIdSucursal(idSucursal))
                .stream()
                .filter(v -> v.getEstadoVenta().getIdEstadoVenta() == estado)
                .peek(v -> {
                    try {
                        ventaDetService.getByVentaCab(v.getIdVentaCab());
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }).collect(Collectors.toList());
    }

    @Override
    public List<VentaCabDTO> getByCliente(Integer idcliente, Boolean all,
            Integer idestado) throws Exception {
        // TODO Auto-generated method stub
        List<VentaCabDTO> list = mapper
                .entityListToDtoList(repo.findByClienteIdCliente(idcliente))
                .stream().peek(v -> {
                    try {
                        ventaDetService.getByVentaCab(v.getIdVentaCab());
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }).collect(Collectors.toList());

        if (!all) {
            return mapper
                    .entityListToDtoList(
                            repo.findByClienteIdCliente(idcliente))
                    .stream().filter(v -> v.getEstadoVenta()
                            .getIdEstadoVenta() == idestado)
                    .peek(v -> {
                        try {
                            ventaDetService.getByVentaCab(v.getIdVentaCab());
                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }
                    }).collect(Collectors.toList());

        }

        return list;
    }

    @Override
    public VentaCabDTO registrarPedido(VentaCabDTO ventacab, UsuarioDTO usuario)
            throws Exception {
        try {
            ventacab.setUsuario(usuario);
            ventacab.setEmpresa(usuario.getEmpresa());
            ventacab.setFecha(new Date(System.currentTimeMillis()));
            ventacab.setSucursal(usuario.getSucursal());
            ventacab.setDeposito(usuario.getDeposito());
            EstadoVentaDTO estado = new EstadoVentaDTO();
            estado.setIdEstadoVenta(1);
            ventacab.setEstadoVenta(estado);
            MonedaDTO moneda = new MonedaDTO();
            moneda.setCodMoneda(1);
            ventacab.setMoneda(moneda);
            // ventacab.setTurno(login.getTurno());

            VentaCabDTO newDto = grabar(ventacab);

            ventacab.getDetalles().stream().forEach(det -> {

                try {
                    det.setVentaCab(newDto);
                    ventaDetService.grabar(det);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            return newDto;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}
