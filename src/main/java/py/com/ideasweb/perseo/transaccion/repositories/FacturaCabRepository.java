package py.com.ideasweb.perseo.transaccion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.FacturaCabEntity;

public interface FacturaCabRepository
        extends JpaRepository<FacturaCabEntity, Integer> {

    List<FacturaCabEntity> findBySucursalIdSucursal(Integer idSucursal);

    List<FacturaCabEntity> findBySucursalIdSucursalAndEstado(Integer idSucursal,
            Boolean estado);

    List<FacturaCabEntity> findByClienteIdCliente(Integer idCliente);

    List<FacturaCabEntity> findByClienteIdClienteAndEstado(Integer idCliente,
            Boolean estado);

    List<FacturaCabEntity> findByTurnoIdTurno(Integer idTurno);

}
