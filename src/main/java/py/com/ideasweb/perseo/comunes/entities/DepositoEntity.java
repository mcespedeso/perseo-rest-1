package py.com.ideasweb.perseo.comunes.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;

@Entity
@Table(name = "deposito")
@JsonInclude(Include.NON_NULL)
public class DepositoEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "depositoSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "deposito_id_deposito_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "depositoSequenceGenerator")
    @Column(name = "id_deposito")
    private Integer idDeposito;

    private String descripcion;

    private Boolean estado;

    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    SucursalEntity sucursal;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    EmpresaEntity empresa;

    private Timestamp fechaLog;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario")
    UsuarioEntity usuario;

    public DepositoEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(Integer idDeposito) {
        this.idDeposito = idDeposito;
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

    public Timestamp getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @PrePersist
    public void preSave() {
        this.fechaLog = new Timestamp(System.currentTimeMillis());
    }

}
