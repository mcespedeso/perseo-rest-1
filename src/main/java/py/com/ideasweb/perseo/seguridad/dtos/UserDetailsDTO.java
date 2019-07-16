package py.com.ideasweb.perseo.seguridad.dtos;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by mcespedes
 */
public class UserDetailsDTO implements UserDetails {

    private final String password;
    private final String passwordApp;
    private final String login;
    private final boolean activo;
    private final int idUsuario;
    private final List<GrantedAuthority> grantedAuthorities;

    UserDetailsDTO(String passwordApp, String password, String login,
            boolean activo, int idUsuario,
            List<GrantedAuthority> grantedAuthorities) {
        this.passwordApp = passwordApp;
        this.password = password;
        this.login = login;
        this.activo = activo;
        this.idUsuario = idUsuario;
        this.grantedAuthorities = grantedAuthorities;
    }

    public static UserDetailsDTOBuilder builder() {
        return new UserDetailsDTOBuilder();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // we never lock accounts
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // credentials never expire
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activo;
    }

    public String getPasswordApp() {
        return passwordApp;
    }

    public boolean isActivo() {
        return activo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public List<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

}
