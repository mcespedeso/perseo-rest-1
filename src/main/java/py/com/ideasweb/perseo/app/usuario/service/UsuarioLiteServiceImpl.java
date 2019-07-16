package py.com.ideasweb.perseo.app.usuario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.app.usuario.model.UsuarioLite;
import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.seguridad.services.PerfilUsuarioService;
import py.com.ideasweb.perseo.seguridad.services.UsuarioService;

@Service
public class UsuarioLiteServiceImpl extends BaseServiceImpl
        implements UsuarioLiteService {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PerfilUsuarioService perfilUsuarioService;

    @Override
    public List<UsuarioLite> findAll() {
        // return usuarioRepository.findAll();

        return null;
    }

    @Override
    public List<UsuarioLite> findByEmpresa(Integer idEmpresa) {

        List<UsuarioLite> list = new ArrayList<>();
        usuarioService.getByEmpresa(idEmpresa).stream().peek(u -> {

            u.setPerfiles(perfilUsuarioService.findByUsuario(u.getIdUsuario()));
            list.add(new UsuarioLite(u));
        }).collect(Collectors.toList());

        return list;
    }

    @Override
    public UsuarioLite getById(Integer idUsuario) {

        UsuarioDTO user = usuarioService.getUserById(idUsuario);
        user.setPerfiles(
                perfilUsuarioService.findByUsuario(user.getIdUsuario()));

        return new UsuarioLite(user);
        // return user;
    }

    @Override
    public UsuarioLite grabar(UsuarioLite usuario) {
        // TODO Auto-generated method stub

        UsuarioDTO user = new UsuarioDTO(usuario);

        if (usuario.getPassword() != null) {
            user.setPasswordApp(usuario.getPassword());
            user.setPassword(usuario.getPassword());
        }

        return new UsuarioLite(usuarioService.addUser(user));

    }

}
