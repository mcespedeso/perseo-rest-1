package py.com.ideasweb.perseo.transaccion.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.CompraCabEntity;

public interface CompraCabRepository
        extends JpaRepository<CompraCabEntity, Integer> {

    List<CompraCabEntity> findByTurnoIdTurno(Integer idTurno);

    List<CompraCabEntity> findByEmpresaIdEmpresaAndFechaBetween(
            Integer idEmpresa, Date fechaDesde, Date fechahasta);

    List<CompraCabEntity> findByProveedorIdProveedorAndFechaBetween(
            Integer idProveedor, Date fechaDesde, Date fechahasta);

    List<CompraCabEntity> findBySucursalIdSucursalAndFechaBetween(
            Integer idSucursal, Date fechaDesde, Date fechahasta);
}
