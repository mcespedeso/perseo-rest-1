package py.com.ideasweb.perseo.transaccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.TipoFacturaEntity;

public interface TipoFacturaRepository
        extends JpaRepository<TipoFacturaEntity, Integer> {

}
