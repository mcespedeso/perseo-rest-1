package py.com.ideasweb.perseo.seguridad.dtos;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class UserDetailsDTOBuilder {
    private String passwordApp;
    private String password;
    private String login;
    private boolean activo;
    private int idUsuario;
    private List<GrantedAuthority> grantedAuthorities;

    public UserDetailsDTOBuilder login(String login) {
        this.login = login;
        return this;
    }

    public UserDetailsDTOBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserDetailsDTOBuilder activo(boolean activo) {
        this.activo = activo;
        return this;
    }

    public UserDetailsDTOBuilder idUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UserDetailsDTOBuilder passwordApp(String passwordApp) {
        this.passwordApp = passwordApp;
        return this;
    }

    public UserDetailsDTOBuilder grantedAuthorities(
            List<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
        return this;
    }

    public UserDetailsDTO build() {
        return new UserDetailsDTO(passwordApp, password, login, activo,
                idUsuario, grantedAuthorities);
    }
}