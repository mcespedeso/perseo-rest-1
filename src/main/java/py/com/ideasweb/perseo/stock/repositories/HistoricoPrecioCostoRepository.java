package py.com.ideasweb.perseo.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import py.com.ideasweb.perseo.stock.entities.HistoricoPrecioCostoEntity;

public interface HistoricoPrecioCostoRepository
        extends JpaRepository<HistoricoPrecioCostoEntity, Integer> {

    @Query(value = "select avg(precio_costo) as prom from historico_precio_costo where id_articulo = :idArticulo", nativeQuery = true)
    Double findPromedioCostoByArticulo(@Param("idArticulo") Integer idArticulo);

}
