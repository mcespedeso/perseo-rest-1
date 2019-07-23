package py.com.ideasweb.perseo.transaccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import py.com.ideasweb.perseo.transaccion.entities.FacturaEntity;

public interface FacturaRepository
        extends JpaRepository<FacturaEntity, Integer> {

    @Query(value = "select * from factura where m.id_caja = :idCaja and valido_hasta <= now() and nro_actual < nro_final", nativeQuery = true)
    FacturaEntity findByCaja(@Param("idCaja") Integer idCaja);
}
