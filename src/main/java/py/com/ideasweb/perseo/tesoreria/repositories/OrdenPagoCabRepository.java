package py.com.ideasweb.perseo.tesoreria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.tesoreria.entities.OrdenPagoCabEntity;

public interface OrdenPagoCabRepository
        extends JpaRepository<OrdenPagoCabEntity, Integer> {

    List<OrdenPagoCabEntity> findByEmpresaIdEmpresa(Integer idEmpresa);

    List<OrdenPagoCabEntity> findBySucursalIdSucursal(Integer idEmpresa);

}
