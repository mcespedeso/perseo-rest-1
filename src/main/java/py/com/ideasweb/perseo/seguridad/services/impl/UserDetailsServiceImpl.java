package py.com.ideasweb.perseo.seguridad.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.seguridad.dtos.UserDetailsDTO;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioRoleEntity;
import py.com.ideasweb.perseo.seguridad.repositories.UserRepository;
import py.com.ideasweb.perseo.seguridad.repositories.UserRoleRepository;

/**
 * Created by jdferrira
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOG = LoggerFactory
            .getLogger(UserDetailsServiceImpl.class);

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepo;

    public UserDetailsServiceImpl(UserRepository userRepository,
            UserRoleRepository userRoleRepo) {
        this.userRepository = userRepository;
        this.userRoleRepo = userRoleRepo;

    }

    @Override
    public UserDetailsDTO loadUserByUsername(String username)
            throws UsernameNotFoundException {
        LOG.info("Loading user details: {}", username);

        UsuarioEntity user = userRepository.findOneByLoginIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Nombre de usuario no se encuentra " + username));

        LOG.info("user son " + user.toString());
        
        List<UsuarioRoleEntity> roles = userRoleRepo.findByLogin(user.getLogin());
        
//        List<UsuarioRoleEntity> roles = userRoleRepo.findByUser(user.getIdUsuario());
        
//        List<UsuarioRoleEntity> roles = new ArrayList<UsuarioRoleEntity>();
//        UsuarioRoleEntity ur = new UsuarioRoleEntity();
//        ur.setUsuario(user);
//        ur.setRoles(new RolesEntity(1 , "ADMIN"));
//        
//        roles.add(ur);
        
        LOG.info("roles son " + roles.size());

        return UserDetailsDTO.builder().login(user.getLogin())
                .activo(user.isActivo()).password(user.getPassword())
                .password(user.getPassword())
                .idUsuario(user.getIdUsuario().intValue())
                .grantedAuthorities(this.getGrantedAuthorities(roles)).build();
    }

    public List<GrantedAuthority> getGrantedAuthorities(
            List<UsuarioRoleEntity> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UsuarioRoleEntity role : roles) {
            authorities
                    .add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }

}
