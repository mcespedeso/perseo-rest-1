package py.com.ideasweb.perseo.seguridad.dtos;

import java.io.Serializable;

public class MenuDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idMenu;

    private String descripcion;

    private Boolean estado;

    private String tipo;

    private String mnemonic;

    private PerfilDTO perfil;

    private ClaseDTO clase;

    private MenuDTO menuAnterior;

    private Integer orden;

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public PerfilDTO getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDTO perfil) {
        this.perfil = perfil;
    }

    public ClaseDTO getClase() {
        return clase;
    }

    public void setClase(ClaseDTO clase) {
        this.clase = clase;
    }

    public MenuDTO getMenuAnterior() {
        return menuAnterior;
    }

    public void setMenuAnterior(MenuDTO menuAnterior) {
        this.menuAnterior = menuAnterior;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

}
