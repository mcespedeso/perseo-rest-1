package py.com.ideasweb.perseo.seguridad.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;

/**
 * Created by jdferreira
 */
public interface UserRepository extends JpaRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findOneByLoginIgnoreCase(String login);

    UsuarioEntity findByLogin(String login);

    Page<UsuarioEntity> findAll(Pageable page);

    List<UsuarioEntity> findAll();
    
    List<UsuarioEntity> findByEmpresaIdEmpresa(Integer idEmpresa);

    /*
     * @Query(value =
     * "select * from seguridad.usuario u join salud.medico m on u.id_persona = m.id_persona where m.id_medico = :idMedico"
     * , nativeQuery = true) UsuarioEntity
     * findByMedicoIdMedico(@Param("idMedico") Long idMedico);
     */

}