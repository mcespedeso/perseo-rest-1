package py.com.ideasweb.perseo.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.ArticuloPrecioVentaDetEntity;

public interface ArticuloPrecioVentaDetRepository
        extends JpaRepository<ArticuloPrecioVentaDetEntity, Integer> {

    List<ArticuloPrecioVentaDetEntity> findByArticuloPrecioVentaCabIdArticuloPrecioVentaCab(
            Integer idArticuloPrecioVentaCab);

    ArticuloPrecioVentaDetEntity findByArticuloPrecioVentaCabIdArticuloPrecioVentaCabAndArticuloIdArticulo(
            Integer idArticuloPrecioVentaCab, Integer idArticulo);
}
