package py.com.ideasweb.perseo.transaccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.VentaDetEntity;

public interface VentaDetRepository
        extends JpaRepository<VentaDetEntity, Integer> {

}
