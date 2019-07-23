package py.com.ideasweb.perseo.transaccion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.VentaDetEntity;

public interface VentaDetRepository
        extends JpaRepository<VentaDetEntity, Integer> {

    List<VentaDetEntity> findByVentaCabIdVentaCab(Integer idVentaCab);
}
