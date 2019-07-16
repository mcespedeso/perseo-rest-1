package py.com.ideasweb.perseo.seguridad.services.impl;

import static com.google.common.base.Preconditions.checkArgument;

import java.beans.FeatureDescriptor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.ideasweb.perseo.exceptions.ForbiddenException;
import py.com.ideasweb.perseo.exceptions.InternalServerErrorException;
import py.com.ideasweb.perseo.exceptions.UnknownResourceException;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.seguridad.entities.RolesEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioRoleEntity;
import py.com.ideasweb.perseo.seguridad.mapper.UsuarioMapper;
import py.com.ideasweb.perseo.seguridad.repositories.RoleRepository;
import py.com.ideasweb.perseo.seguridad.repositories.UserRepository;
import py.com.ideasweb.perseo.seguridad.repositories.UserRoleRepository;
import py.com.ideasweb.perseo.seguridad.services.PerfilUsuarioService;
import py.com.ideasweb.perseo.seguridad.services.UsuarioService;
import py.com.ideasweb.perseo.utilities.MD5Generator;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger LOG = LoggerFactory
            .getLogger(UsuarioServiceImpl.class);

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

    private RoleRepository roleRepo;

    private final UsuarioMapper userMapper;

    @Autowired
    PerfilUsuarioService perfilUsuarioService;

    public UsuarioServiceImpl(UserRepository userRepository,
            UserRoleRepository userRoleRepository, RoleRepository roleRepo,
            UsuarioMapper userMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleRepo = roleRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UsuarioDTO addUser(UsuarioDTO usuarioDTO) {

        UsuarioEntity user = new UsuarioEntity();

        Optional<UsuarioEntity> optional = userRepository
                .findOneByLoginIgnoreCase(usuarioDTO.getLogin());

        if (optional.isPresent()) {
            user.setIdUsuario(optional.get().getIdUsuario());
        } else {
            BeanUtils.copyProperties(usuarioDTO, user,
                    getNullPropertyNames(usuarioDTO));
        }

        if (usuarioDTO.getPassword() != null) {
            user.setPassword(getHashPassword(usuarioDTO.getPassword()));
            user.setPasswordApp(MD5Generator.MD5(user.getPassword()));
        }

        UsuarioEntity newUser = userRepository.save(user);

        // insertar user roles, USUARIO
        userRoleRepository.deleteByUsuarioIdUsuario(newUser.getIdUsuario());
        RolesEntity roleUser = roleRepo.getOne(2);
        UsuarioRoleEntity uRoleUser = new UsuarioRoleEntity();
        uRoleUser.setRoles(roleUser);
        uRoleUser.setUsuario(newUser);
        userRoleRepository.save(uRoleUser);

        // insertar perfiles
        if (usuarioDTO.getPerfiles() != null) {
            perfilUsuarioService.deleteByUsuario(newUser.getIdUsuario());
            usuarioDTO.getPerfiles().forEach(p -> {
                p.setIdUsuario(newUser.getIdUsuario());
                perfilUsuarioService.grabar(p);
            });
        }

        return userMapper.entityToDto(newUser);
    }

    @Override
    public UsuarioDTO getUserById(Integer userId) {
        checkArgument(userId > 0, "Argument was %s but expected nonnegative",
                userId);

        Optional<UsuarioEntity> userOptional = userRepository.findById(userId);

        return userOptional.map(userMapper::entityToDto)
                .orElseThrow(() -> new UnknownResourceException(
                        "No se encuentra el usuario con id " + userId));

    }

    @Override
    public List<UsuarioDTO> getAllUsers() {
        List<UsuarioEntity> users = userRepository.findAll();
        return userMapper.entityListToDtoList(users);
    }

    @Override
    public void deleteUser(Integer userId) {
        checkArgument(userId > 0, "Argument was %s but expected nonnegative",
                userId);

        userRepository.findById(userId).ifPresent(u -> {
            u.setActivo(false);
            userRepository.save(u);
        });
    }

    @Override
    public UsuarioDTO updateUser(UsuarioDTO userDTO) {
        checkArgument(userDTO.getIdUsuario() > 0,
                "Argument was %s but expected nonnegative",
                userDTO.getIdUsuario());

        String[] ignoredProperties = getNullPropertyNames(userDTO);

        return Optional
                .ofNullable(
                        userRepository.findById(userDTO.getIdUsuario()).get())
                .map(user -> {
                    BeanUtils.copyProperties(userDTO, user, ignoredProperties);
                    LOG.debug("Changed Information for User: {}", user);
                    userRepository.save(user);

                    return user;
                }).map(userMapper::entityToDto)
                .orElseThrow(() -> new UnknownResourceException(
                        "User does not exist"));
    }

    @Override
    public String getHashPassword(String pass) {
        BCryptPasswordEncoder cryp = new BCryptPasswordEncoder();
        return cryp.encode(pass);
    }

    @Override
    public UsuarioDTO getUserByUsername(String username) {
        checkArgument(username.length() > 0,
                "Argument was %s but expected no empty", username);

        Optional<UsuarioEntity> userOptional = userRepository
                .findOneByLoginIgnoreCase(username);

        return userOptional.map(userMapper::entityToDto)
                .orElse(new UsuarioDTO());
    }

    private String[] getNullPropertyNames(UsuarioDTO user) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(user);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource
                        .getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

    @Override
    public Boolean updatePassword(String oldPassword, String newPassword,
            Integer idUsuario) {
        // TODO Auto-generated method stub

        UsuarioDTO user = getUserById(idUsuario);

        if (!BCrypt.checkpw(user.getPassword(), oldPassword)) {
            throw new ForbiddenException("La contraseña anterior no coincide");
        }

        if (newPassword.indexOf(" ") > -1) {
            throw new InternalServerErrorException(
                    "Su contraseña contiene caracteres invalidos");
        }

        user.setPassword(getHashPassword(newPassword));

        updateUser(user);

        return true;

    }

    @Override
    public List<UsuarioDTO> getByEmpresa(Integer idEmpresa) {
        // TODO Auto-generated method stub
        return userMapper.entityListToDtoList(
                userRepository.findByEmpresaIdEmpresa(idEmpresa));
    }

}