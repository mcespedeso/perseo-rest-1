package py.com.ideasweb.perseo.transaccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.CompraDetEntity;

public interface CompraDetRepository
        extends JpaRepository<CompraDetEntity, Integer> {

}
