package py.com.ideasweb.perseo.tesoreria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.tesoreria.entities.OrdenPagoDetEntity;

public interface OrdenPagoDetRepository
        extends JpaRepository<OrdenPagoDetEntity, Integer> {

    List<OrdenPagoDetEntity> findByOrdenPagoCabIdOrdenPagoCab(
            Integer idOrdenPagoCab);

}
