package py.com.ideasweb.perseo.tesoreria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.tesoreria.entities.OrdenPagoFpEntity;

public interface OrdenPagoFpRepository
        extends JpaRepository<OrdenPagoFpEntity, Integer> {

    List<OrdenPagoFpEntity> findByOrdenPagoCabIdOrdenPagoCab(
            Integer idOrdenPagoCab);

    List<OrdenPagoFpEntity> findByCajaCuentaIdCajaCuenta(Integer idCajaCuenta);

}
