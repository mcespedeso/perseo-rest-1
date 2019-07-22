package py.com.ideasweb.perseo.seguridad.services;

import java.util.List;

import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;

public interface UsuarioService {

    UsuarioDTO updateUser(UsuarioDTO user);

    UsuarioDTO addUser(UsuarioDTO user);

    UsuarioDTO getUserById(Integer userId);

    List<UsuarioDTO> getAllUsers();

    void deleteUser(Integer userId);

    String getHashPassword(String pass);

    UsuarioDTO getUserByUsername(String username);

    Boolean updatePassword(String oldPassword, String newPassword,
            Integer idUsuario);

    List<UsuarioDTO> getByEmpresa(Integer idEmpresa);

    Boolean checkPassword(Integer idusuario, String password) throws Exception;

}