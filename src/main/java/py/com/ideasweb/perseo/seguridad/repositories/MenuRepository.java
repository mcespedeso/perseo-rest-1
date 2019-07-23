package py.com.ideasweb.perseo.seguridad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.seguridad.entities.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

    List<MenuEntity> findByTipoAndPerfilIdPerfilAndEstadoOrderByOrdenAsc(
            String tipo, Integer idPerfil, Boolean estado);

    List<MenuEntity> findByTipoAndPerfilIdPerfilOrderByOrdenAsc(String tipo,
            Integer idPerfil);
}
