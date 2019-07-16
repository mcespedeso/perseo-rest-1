package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import py.com.ideasweb.perseo.comunes.dtos.DepositoDTO;
import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;

public class ArticuloDepositoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idArticuloDeposito;

    private UsuarioDTO usuario;

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

    private SucursalDTO sucursal;

    private ArticuloDTO articulo;;

    private DepositoDTO deposito;

    private EmpresaDTO empresa;

    public Integer getIdArticuloDeposito() {
        return idArticuloDeposito;
    }

    public void setIdArticuloDeposito(Integer idArticuloDeposito) {
        this.idArticuloDeposito = idArticuloDeposito;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
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

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    public ArticuloDTO getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloDTO articulo) {
        this.articulo = articulo;
    }

    public DepositoDTO getDeposito() {
        return deposito;
    }

    public void setDeposito(DepositoDTO deposito) {
        this.deposito = deposito;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }
    
    

}
