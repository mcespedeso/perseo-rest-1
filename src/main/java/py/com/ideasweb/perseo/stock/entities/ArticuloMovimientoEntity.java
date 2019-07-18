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
import py.com.ideasweb.perseo.comunes.entities.SucursalEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;
import py.com.ideasweb.perseo.tesoreria.entities.ConceptoMovEntity;
import py.com.ideasweb.perseo.transaccion.entities.CompraCabEntity;
import py.com.ideasweb.perseo.transaccion.entities.TurnoEntity;
import py.com.ideasweb.perseo.transaccion.entities.VentaCabEntity;

@Entity
@Table(name = "articulo_movimiento")
public class ArticuloMovimientoEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "articuloSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "articulo_id_articulo_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "articuloSequenceGenerator")
    @Column(name = "id_articulo_movimiento")
    private Integer idArticuloMovimiento;

    private Date fecha;

    private Timestamp fechaLog;

    @ManyToOne(targetEntity = ArticuloEntity.class)
    @JoinColumn(name = "id_articulo", nullable = false)
    private ArticuloEntity articulo;;

    @ManyToOne(targetEntity = DepositoEntity.class)
    @JoinColumn(name = "id_deposito", nullable = false)
    private DepositoEntity deposito;

    @ManyToOne(targetEntity = ConceptoMovEntity.class)
    @JoinColumn(name = "id_concepto_mov", nullable = false)
    private ConceptoMovEntity conceptoMov;

    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursal;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne(targetEntity = TurnoEntity.class)
    @JoinColumn(name = "id_turno")
    private TurnoEntity turno;

    @ManyToOne(targetEntity = VentaCabEntity.class)
    @JoinColumn(name = "id_venta_cab")
    private VentaCabEntity ventaCab;

    @ManyToOne(targetEntity = CompraCabEntity.class)
    @JoinColumn(name = "id_compra_cab")
    private CompraCabEntity compraCab;

    private Double cantidad;

    private String columna;

    private String obs;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

    public Integer getIdArticuloMovimiento() {
        return idArticuloMovimiento;
    }

    public void setIdArticuloMovimiento(Integer idArticuloMovimiento) {
        this.idArticuloMovimiento = idArticuloMovimiento;
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

    public ArticuloEntity getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloEntity articulo) {
        this.articulo = articulo;
    }

    public DepositoEntity getDeposito() {
        return deposito;
    }

    public void setDeposito(DepositoEntity deposito) {
        this.deposito = deposito;
    }

    public ConceptoMovEntity getConceptoMov() {
        return conceptoMov;
    }

    public void setConceptoMov(ConceptoMovEntity conceptoMov) {
        this.conceptoMov = conceptoMov;
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

    public TurnoEntity getTurno() {
        return turno;
    }

    public void setTurno(TurnoEntity turno) {
        this.turno = turno;
    }

    public VentaCabEntity getVentaCab() {
        return ventaCab;
    }

    public void setVentaCab(VentaCabEntity ventaCab) {
        this.ventaCab = ventaCab;
    }

    public CompraCabEntity getCompraCab() {
        return compraCab;
    }

    public void setCompraCab(CompraCabEntity compraCab) {
        this.compraCab = compraCab;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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
