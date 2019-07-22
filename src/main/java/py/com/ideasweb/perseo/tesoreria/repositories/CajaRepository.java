package py.com.ideasweb.perseo.tesoreria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.tesoreria.entities.CajaEntity;

public interface CajaRepository extends JpaRepository<CajaEntity, Integer> {

    List<CajaEntity> findByEmpresaIdEmpresa(Integer idEmpresa);

    List<CajaEntity> findBySucursalIdSucursal(Integer idSucursal);

}
