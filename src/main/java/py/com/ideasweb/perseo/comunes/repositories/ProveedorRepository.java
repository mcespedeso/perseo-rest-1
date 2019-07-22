package py.com.ideasweb.perseo.comunes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.comunes.entities.ProveedorEntity;

public interface ProveedorRepository
        extends JpaRepository<ProveedorEntity, Integer> {

    List<ProveedorEntity> findByEmpresaIdEmpresa(Integer idEmpresa);

    List<ProveedorEntity> findByDescripcionIgnoreCaseContainingOrNrodocIgnoreCaseContainingAndEmpresaIdEmpresa(
            String descripcion, String nrodoc, Integer idEmpresa);

}
