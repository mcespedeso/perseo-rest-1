package py.com.ideasweb.perseo.transaccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.EstadoCompraEntity;

public interface EstadoCompraRepository
        extends JpaRepository<EstadoCompraEntity, Integer> {

}
