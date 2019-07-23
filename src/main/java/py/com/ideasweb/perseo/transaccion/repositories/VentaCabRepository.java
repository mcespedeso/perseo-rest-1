package py.com.ideasweb.perseo.transaccion.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.VentaCabEntity;

public interface VentaCabRepository
        extends JpaRepository<VentaCabEntity, Integer> {

    List<VentaCabEntity> findByEmpresaIdEmpresa(Integer idEmpresa);

    List<VentaCabEntity> findByEmpresaIdEmpresaAndFechaBetween(
            Integer idEmpresa, Date fechaDesde, Date fechaHasta);

    List<VentaCabEntity> findBySucursalIdSucursal(Integer idSucursal);

    List<VentaCabEntity> findByClienteIdCliente(Integer idCliente);
}
