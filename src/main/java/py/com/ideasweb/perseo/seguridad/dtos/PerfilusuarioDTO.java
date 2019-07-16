package py.com.ideasweb.perseo.seguridad.dtos;

import java.io.Serializable;

public class PerfilusuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer idUsuario;
    private PerfilDTO perfil;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public PerfilDTO getPerfil() {
        return perfil;
    }
    public void setPerfil(PerfilDTO perfil) {
        this.perfil = perfil;
    }
    
    

}
