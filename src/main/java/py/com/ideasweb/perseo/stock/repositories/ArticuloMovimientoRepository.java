package py.com.ideasweb.perseo.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.ArticuloMovimientoEntity;

public interface ArticuloMovimientoRepository
        extends JpaRepository<ArticuloMovimientoEntity, Integer> {

}
