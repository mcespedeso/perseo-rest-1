package py.com.ideasweb.perseo.transaccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.VentaCabEntity;

public interface VentaCabRepository
        extends JpaRepository<VentaCabEntity, Integer> {

}
