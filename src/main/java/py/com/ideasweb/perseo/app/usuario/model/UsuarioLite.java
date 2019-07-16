package py.com.ideasweb.perseo.app.usuario.model;

import java.util.List;

import javax.persistence.Transient;

import py.com.ideasweb.perseo.seguridad.dtos.PerfilusuarioDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;

public class UsuarioLite {
    private Integer idUsuario;

    private String login;
    private String password;
    private String nombreApellido;
    private String nroDocumento;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String barrio;
    private Integer idSucursal;
    private Integer idDeposito;
    private Integer idEmpresa;
    private Boolean activo;

    
    private List<PerfilusuarioDTO> perfiles;
    

    public UsuarioLite() {
        super();
    }
    
    

    public UsuarioLite(UsuarioDTO dto) {
        super();
        this.idUsuario = dto.getIdUsuario();
        this.login = dto.getLogin();
        this.password = dto.getPasswordApp();
        this.nombreApellido = dto.getNombreApellido();
        this.nroDocumento = dto.getNroDocumento();
        this.direccion = dto.getDireccion();
        this.telefono = dto.getTelefono();
        this.idSucursal = dto.getSucursal().getIdSucursal();
        this.idDeposito = dto.getDeposito().getIdDeposito();
        this.idEmpresa = dto.getEmpresa().getIdEmpresa();
        this.activo = dto.getActivo();
        this.perfiles = dto.getPerfiles();
    }



    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Integer getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(Integer idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public List<PerfilusuarioDTO> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<PerfilusuarioDTO> perfiles) {
        this.perfiles = perfiles;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    
    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", login=" + login
                + ", password=" + password + ", nombreApellido="
                + nombreApellido + ", nroDocumento=" + nroDocumento
                + ", direccion=" + direccion + ", telefono=" + telefono
                + ", ciudad=" + ciudad + ", barrio=" + barrio + ", idSucursal="
                + idSucursal + ", idDeposito=" + idDeposito + ", idEmpresa="
                + idEmpresa + ", activo=" + activo + ", perfiles=" + perfiles
                + "]";
    }

}
