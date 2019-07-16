package py.com.ideasweb.perseo.stock.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.ArticuloEntity;

public interface ArticuloRepository
        extends JpaRepository<ArticuloEntity, Integer> {

    List<ArticuloEntity> findByEmpresaIdEmpresa(Integer idEmpresa);

    List<ArticuloEntity> findByFamiliaIdFamilia(Integer idFamilia);

    List<ArticuloEntity> findByDescripcionContainsIgnoreCaseOrCodigoBarraContainsIgnoreCase(
            String descripcion, String codigoBarra);

}
