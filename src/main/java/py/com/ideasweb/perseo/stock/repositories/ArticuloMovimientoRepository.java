package py.com.ideasweb.perseo.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.ArticuloMovimientoEntity;

public interface ArticuloMovimientoRepository
        extends JpaRepository<ArticuloMovimientoEntity, Integer> {

    List<ArticuloMovimientoEntity> findByEmpresaIdEmpresa(Integer idEmpresa);

    List<ArticuloMovimientoEntity> findByDepositoIdDeposito(Integer idDeposito);

    List<ArticuloMovimientoEntity> findByArticuloIdArticulo(Integer idArticulo);

    List<ArticuloMovimientoEntity> findByArticuloIdArticuloAndDepositoIdDeposito(
            Integer idArticulo, Integer idDeposito);
}
