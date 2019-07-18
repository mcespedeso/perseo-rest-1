package py.com.ideasweb.perseo.stock.entities;

import java.sql.Date;
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

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.comunes.entities.DepositoEntity;
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;

@Entity
@Table(name = "articulo_transferencia_cab")
public class ArticuloTransferenciaCabEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "articuloTransferenciaCabSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "articulo_transferencia_cab_id_articulo_transferencia_cab_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "articuloTransferenciaCabSequenceGenerator")

    @Column(name = "id_articulo_transferencia_cab")
    private Integer idArticuloTransferenciaCab;

    private Boolean estado;

    private Date fecha;

    private Timestamp fechaLog;

    private Integer cantidadTotal;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne(targetEntity = DepositoEntity.class)
    @JoinColumn(name = "id_deposito_origen", nullable = false)
    private DepositoEntity depositoOrigen;

    @ManyToOne(targetEntity = DepositoEntity.class)
    @JoinColumn(name = "id_deposito_destino", nullable = false)
    private DepositoEntity depositoDestino;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

    public Integer getIdArticuloTransferenciaCab() {
        return idArticuloTransferenciaCab;
    }

    public void setIdArticuloTransferenciaCab(
            Integer idArticuloTransferenciaCab) {
        this.idArticuloTransferenciaCab = idArticuloTransferenciaCab;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Timestamp getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }

    public Integer getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public DepositoEntity getDepositoOrigen() {
        return depositoOrigen;
    }

    public void setDepositoOrigen(DepositoEntity depositoOrigen) {
        this.depositoOrigen = depositoOrigen;
    }

    public DepositoEntity getDepositoDestino() {
        return depositoDestino;
    }

    public void setDepositoDestino(DepositoEntity depositoDestino) {
        this.depositoDestino = depositoDestino;
    }

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

    @PrePersist
    public void preSave() {
        this.fechaLog = new Timestamp(System.currentTimeMillis());
    }

}
