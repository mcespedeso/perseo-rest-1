package py.com.ideasweb.perseo.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.HistoricoPrecioCostoEntity;

public interface HistoricoPrecioCostoRepository
        extends JpaRepository<HistoricoPrecioCostoEntity, Integer> {

}
