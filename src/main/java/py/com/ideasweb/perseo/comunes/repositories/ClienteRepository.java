package py.com.ideasweb.perseo.comunes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.comunes.entities.ClienteEntity;

public interface ClienteRepository
        extends JpaRepository<ClienteEntity, Integer> {

    List<ClienteEntity> findByEmpresaIdEmpresa(Integer idEmpresa);

    List<ClienteEntity> findByTipoDocumentoCodTipoDocAndNrodoc(
            String idTipoDocumento, String documento);

    List<ClienteEntity> findByNombreApellidoIgnoreCaseContaining(
            String nombres);

    Optional<ClienteEntity> findByNrodoc(String nrodoc);

}
