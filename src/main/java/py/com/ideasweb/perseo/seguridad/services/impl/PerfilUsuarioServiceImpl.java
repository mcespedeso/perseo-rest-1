package py.com.ideasweb.perseo.seguridad.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.seguridad.dtos.PerfilusuarioDTO;
import py.com.ideasweb.perseo.seguridad.mapper.PerfilUsuarioMapper;
import py.com.ideasweb.perseo.seguridad.repositories.PerfilUsuarioRepository;
import py.com.ideasweb.perseo.seguridad.services.PerfilUsuarioService;

@Service
@Transactional
public class PerfilUsuarioServiceImpl implements PerfilUsuarioService {

    @Autowired
    PerfilUsuarioRepository repo;

    @Autowired
    PerfilUsuarioMapper mapper;

    @Override
    public List<PerfilusuarioDTO> findByUsuario(Integer idUsuario) {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findByIdUsuario(idUsuario));
    }

    @Override
    public void grabar(PerfilusuarioDTO perfil) {
        // TODO Auto-generated method stub
        repo.save(mapper.dtoToEntity(perfil));

    }

    @Override
    public void deleteByUsuario(Integer idUsuario) {
        // TODO Auto-generated method stub

        repo.deleteByIdUsuario(idUsuario);
    }

    @Override
    public Boolean ifAsigned(PerfilusuarioDTO perfilusuario) throws Exception {
        // TODO Auto-generated method stub
        if (repo.findByIdUsuarioAndPerfilIdPerfil(perfilusuario.getIdUsuario(),
                perfilusuario.getPerfil().getIdPerfil()).isPresent()) {

            return true;
        }
        return false;
    }

}
