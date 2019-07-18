package py.com.ideasweb.perseo.stock.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.comunes.entities.DepositoEntity;
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;
import py.com.ideasweb.perseo.comunes.entities.SucursalEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;

@Entity
@Table(name = "articulo_deposito")
public class ArticuloDepositoEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "articuloDepositoSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "articulo_deposito_id_articulo_deposito_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "articuloDepositoSequenceGenerator")

    @Column(name = "id_articulo_deposito")
    private Integer idArticuloDeposito;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    private Timestamp fechaLog;

    private Double cantidad;

    private Double cantidadMinima;

    private Double cantidadBloqueo;

    private Double inventarioFisico;

    private Date fechaUltInventario;

    private Date fechaVencimiento;

    private Date fechaUltCompra;

    private Date fechaUltVenta;

    private Integer nroLote;

    private Double precioCosto;

    private Double precioCostoEq;

    private Double precioVenta;

    private Double precioVentaEq;

    private Boolean estado;

    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursal;

    @ManyToOne(targetEntity = ArticuloEntity.class)
    @JoinColumn(name = "id_articulo", nullable = false)
    private ArticuloEntity articulo;

    @ManyToOne(targetEntity = DepositoEntity.class)
    @JoinColumn(name = "id_deposito", nullable = false)
    private DepositoEntity deposito;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

    public Integer getIdArticuloDeposito() {
        return idArticuloDeposito;
    }

    public void setIdArticuloDeposito(Integer idArticuloDeposito) {
        this.idArticuloDeposito = idArticuloDeposito;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public Timestamp getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(Double cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public Double getCantidadBloqueo() {
        return cantidadBloqueo;
    }

    public void setCantidadBloqueo(Double cantidadBloqueo) {
        this.cantidadBloqueo = cantidadBloqueo;
    }

    public Double getInventarioFisico() {
        return inventarioFisico;
    }

    public void setInventarioFisico(Double inventarioFisico) {
        this.inventarioFisico = inventarioFisico;
    }

    public Date getFechaUltInventario() {
        return fechaUltInventario;
    }

    public void setFechaUltInventario(Date fechaUltInventario) {
        this.fechaUltInventario = fechaUltInventario;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaUltCompra() {
        return fechaUltCompra;
    }

    public void setFechaUltCompra(Date fechaUltCompra) {
        this.fechaUltCompra = fechaUltCompra;
    }

    public Date getFechaUltVenta() {
        return fechaUltVenta;
    }

    public void setFechaUltVenta(Date fechaUltVenta) {
        this.fechaUltVenta = fechaUltVenta;
    }

    public Integer getNroLote() {
        return nroLote;
    }

    public void setNroLote(Integer nroLote) {
        this.nroLote = nroLote;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Double getPrecioCostoEq() {
        return precioCostoEq;
    }

    public void setPrecioCostoEq(Double precioCostoEq) {
        this.precioCostoEq = precioCostoEq;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPrecioVentaEq() {
        return precioVentaEq;
    }

    public void setPrecioVentaEq(Double precioVentaEq) {
        this.precioVentaEq = precioVentaEq;
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

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

}
