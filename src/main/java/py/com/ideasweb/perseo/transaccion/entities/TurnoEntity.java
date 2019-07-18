package py.com.ideasweb.perseo.transaccion.entities;

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
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;
import py.com.ideasweb.perseo.comunes.entities.SucursalEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;
import py.com.ideasweb.perseo.tesoreria.entities.CajaEntity;

@Entity
@Table(name = "turno")
public class TurnoEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "turnoSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "turno_id_turno_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "turnoSequenceGenerator")

    @Column(name = "id_turno")
    private Integer idTurno;

    private Date fecha;

    private Timestamp fechaApertura;

    private Timestamp fechaCierre;

    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursal;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne(targetEntity = CajaEntity.class)
    @JoinColumn(name = "id_caja")
    private CajaEntity caja;

    private Date fechaUltApertura;

    private Date fechaUltCierre;

    private Double totalEfectivo;

    private Double totalCheque;

    private Double totalTarjeta;

    private Double cantVenta;

    private Double cantVentaNula;

    private Double cantCompra;

    private Double cantCompraNula;

    private Boolean estado;

    private String tipoTurno;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

    private Timestamp fechaLog;

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Timestamp getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Timestamp fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Timestamp getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Timestamp fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public SucursalEntity getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public CajaEntity getCaja() {
        return caja;
    }

    public void setCaja(CajaEntity caja) {
        this.caja = caja;
    }

    public Date getFechaUltApertura() {
        return fechaUltApertura;
    }

    public void setFechaUltApertura(Date fechaUltApertura) {
        this.fechaUltApertura = fechaUltApertura;
    }

    public Date getFechaUltCierre() {
        return fechaUltCierre;
    }

    public void setFechaUltCierre(Date fechaUltCierre) {
        this.fechaUltCierre = fechaUltCierre;
    }

    public Double getTotalEfectivo() {
        return totalEfectivo;
    }

    public void setTotalEfectivo(Double totalEfectivo) {
        this.totalEfectivo = totalEfectivo;
    }

    public Double getTotalCheque() {
        return totalCheque;
    }

    public void setTotalCheque(Double totalCheque) {
        this.totalCheque = totalCheque;
    }

    public Double getTotalTarjeta() {
        return totalTarjeta;
    }

    public void setTotalTarjeta(Double totalTarjeta) {
        this.totalTarjeta = totalTarjeta;
    }

    public Double getCantVenta() {
        return cantVenta;
    }

    public void setCantVenta(Double cantVenta) {
        this.cantVenta = cantVenta;
    }

    public Double getCantVentaNula() {
        return cantVentaNula;
    }

    public void setCantVentaNula(Double cantVentaNula) {
        this.cantVentaNula = cantVentaNula;
    }

    public Double getCantCompra() {
        return cantCompra;
    }

    public void setCantCompra(Double cantCompra) {
        this.cantCompra = cantCompra;
    }

    public Double getCantCompraNula() {
        return cantCompraNula;
    }

    public void setCantCompraNula(Double cantCompraNula) {
        this.cantCompraNula = cantCompraNula;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
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

    @PrePersist
    public void preSave() {
        this.fechaLog = new Timestamp(System.currentTimeMillis());
    }

}
