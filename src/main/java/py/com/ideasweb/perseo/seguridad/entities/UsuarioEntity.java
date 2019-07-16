package py.com.ideasweb.perseo.seguridad.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.comunes.entities.DepositoEntity;
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;
import py.com.ideasweb.perseo.comunes.entities.SucursalEntity;

@Entity
@Table(name = "usuario")
public class UsuarioEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "usuarioSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "usuario_id_usuario_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "usuarioSequenceGenerator")
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotNull
    private String login;

    private String password;

    private String passwordApp;

    private boolean activo;

    private String nombreApellido;

    private String nroDocumento;

    private String direccion;

    private String telefono;

    private String correo;

    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    SucursalEntity sucursal;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    EmpresaEntity empresa;

    @ManyToOne(targetEntity = DepositoEntity.class)
    @JoinColumn(name = "id_deposito")
    DepositoEntity deposito;

    private Timestamp fechaLog;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "usuario_log")
    UsuarioEntity usuarioLog;

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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
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

    public SucursalEntity getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

    public DepositoEntity getDeposito() {
        return deposito;
    }

    public void setDeposito(DepositoEntity deposito) {
        this.deposito = deposito;
    }

    public Timestamp getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }

    public UsuarioEntity getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(UsuarioEntity usuarioLog) {
        this.usuarioLog = usuarioLog;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idUsuario == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UsuarioEntity toCompare = (UsuarioEntity) obj;
        return idUsuario.equals(toCompare.idUsuario);
    }

    @Override
    public int hashCode() {
        return idUsuario == null ? 0 : idUsuario.hashCode();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("idUsuario", idUsuario)
                .add("login", login).add("password", password)
                .add("activo", activo).toString();
    }

    @PrePersist
    public void preSave() {
        this.fechaLog = new Timestamp(System.currentTimeMillis());
    }

}
