package py.com.ideasweb.perseo.comunes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.comunes.entities.DepositoEntity;

public interface DepositoRepository
        extends JpaRepository<DepositoEntity, Integer> {

    List<DepositoEntity> findByEmpresaIdEmpresa(Integer idEmpresa);

    List<DepositoEntity> findBySucursalIdSucursal(Integer idSucursal);
}
