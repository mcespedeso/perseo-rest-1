package py.com.ideasweb.perseo.seguridad.dtos;

import java.io.Serializable;

public class PerfilDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idPerfil;

    private String descripcion;

    private Boolean estado;

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    

}
