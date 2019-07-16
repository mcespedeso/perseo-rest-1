package py.com.ideasweb.perseo.seguridad.dtos;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotNull;

import py.com.ideasweb.perseo.app.usuario.model.UsuarioLite;
import py.com.ideasweb.perseo.comunes.dtos.DepositoDTO;
import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idUsuario;

    @NotNull
    private String login;

    private String password;

    private String passwordApp;

    private Boolean activo;

    private String nombreApellido;

    private String nroDocumento;

    private String direccion;

    private String telefono;

    private String correo;

    private SucursalDTO sucursal;

    private EmpresaDTO empresa;

    private DepositoDTO deposito;

    private Timestamp fechaLog;

    private List<PerfilusuarioDTO> perfiles;
    
    

    public UsuarioDTO() {
        super();
    }
    
    

    public UsuarioDTO(UsuarioLite user) {
        super();
        this.idUsuario = user.getIdUsuario();
        this.login = user.getLogin();
        this.passwordApp = user.getPassword();
        this.activo = user.getActivo();
        this.nombreApellido = user.getNombreApellido();
        this.nroDocumento = user.getNroDocumento();
        this.direccion = user.getDireccion();
        this.telefono = user.getTelefono();
        this.sucursal = new SucursalDTO(user.getIdSucursal());
        this.empresa = new EmpresaDTO(user.getIdEmpresa());
        this.deposito = new DepositoDTO(user.getIdDeposito());
        this.perfiles = user.getPerfiles();
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

    public String getPasswordApp() {
        return passwordApp;
    }

    public void setPasswordApp(String passwordApp) {
        this.passwordApp = passwordApp;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public DepositoDTO getDeposito() {
        return deposito;
    }

    public void setDeposito(DepositoDTO deposito) {
        this.deposito = deposito;
    }

    public Timestamp getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }

    public List<PerfilusuarioDTO> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<PerfilusuarioDTO> perfiles) {
        this.perfiles = perfiles;
    }

}
