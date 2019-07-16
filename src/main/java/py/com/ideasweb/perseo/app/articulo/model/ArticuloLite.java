package py.com.ideasweb.perseo.app.articulo.model;

import java.sql.Timestamp;

import py.com.ideasweb.perseo.stock.dtos.ArticuloDepositoDTO;

public class ArticuloLite {

    private Integer idArticulo;
    private String codigoBarra;
    private String descripcion;
    private Double tasaIva;
    private Double precioVenta;
    private Double cantidad;
    private Integer idDeposito;
    private Integer idSucursal;
    private Timestamp fechaLog;
    private Boolean estado;
    private Integer idEmpresa;

    public ArticuloLite() {
        super();
    }

    public ArticuloLite(ArticuloDepositoDTO dto) {
        this.idArticulo = dto.getArticulo().getIdArticulo();
        this.codigoBarra = dto.getArticulo().getCodigoBarra();
        this.descripcion = dto.getArticulo().getDescripcion();
        this.tasaIva = dto.getArticulo().getTipoImpuesto().getTasa();
        this.cantidad = dto.getCantidad();
        this.precioVenta = dto.getPrecioVenta();
        this.idDeposito = dto.getDeposito().getIdDeposito();
        this.idSucursal = dto.getSucursal().getIdSucursal();
        this.idEmpresa = dto.getEmpresa().getIdEmpresa();
        this.estado = dto.getEstado();
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getTasaIva() {
        return tasaIva;
    }

    public void setTasaIva(Double tasaIva) {
        this.tasaIva = tasaIva;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(Integer idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Timestamp getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

}
