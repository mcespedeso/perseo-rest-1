package py.com.ideasweb.perseo.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.ArticuloDepositoEntity;

public interface ArticuloDepositoRepository
        extends JpaRepository<ArticuloDepositoEntity, Integer> {

    ArticuloDepositoEntity findByArticuloIdArticuloAndDepositoIdDeposito(
            Integer idArticulo, Integer idDeposito);

    List<ArticuloDepositoEntity> findBySucursalIdSucursalAndDepositoIdDeposito(
            Integer idSucursal, Integer idDeposito);

    List<ArticuloDepositoEntity> findBySucursalIdSucursalAndDepositoIdDepositoAndArticuloDescripcionContainsIgnoreCaseOrArticuloCodigoBarraContainsIgnoreCase(
            Integer idSucursal, Integer idDeposito, String descripcion,
            String codigoBarra);

    List<ArticuloDepositoEntity> findByEmpresaIdEmpresa(Integer idArticulo);
}
