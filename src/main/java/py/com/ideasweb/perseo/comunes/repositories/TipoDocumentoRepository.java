package py.com.ideasweb.perseo.comunes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.comunes.entities.TipoDocumentoEntity;
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Integer> {

}
