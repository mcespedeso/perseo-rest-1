package py.com.ideasweb.perseo.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.HistoricoPrecioVentaEntity;

public interface HistoricoPrecioVentaRepository
        extends JpaRepository<HistoricoPrecioVentaEntity, Integer> {

}
