package py.com.ideasweb.perseo.transaccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.EstadoVentaEntity;

public interface EstadoVentaRepository
        extends JpaRepository<EstadoVentaEntity, Integer> {

}
