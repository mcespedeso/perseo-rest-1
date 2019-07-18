package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;

import py.com.ideasweb.perseo.comunes.dtos.TipoImpuestoDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDTO;

public class VentaDetDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idVentaDet;

    private VentaCabDTO ventaCab;;

    private ArticuloDTO articulo;

    private Double cantidad;

    private Double precioCosto;

    private Double precioVenta;

    private TipoImpuestoDTO tipoImpuesto;

    private Double impuesto;

    private Double tasaDescuento;

    private Double importeDescuento;

    private Double total;

    public Integer getIdVentaDet() {
        return idVentaDet;
    }

    public void setIdVentaDet(Integer idVentaDet) {
        this.idVentaDet = idVentaDet;
    }

    public VentaCabDTO getVentaCab() {
        return ventaCab;
    }

    public void setVentaCab(VentaCabDTO ventaCab) {
        this.ventaCab = ventaCab;
    }

    public ArticuloDTO getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloDTO articulo) {
        this.articulo = articulo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public TipoImpuestoDTO getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuestoDTO tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getTasaDescuento() {
        return tasaDescuento;
    }

    public void setTasaDescuento(Double tasaDescuento) {
        this.tasaDescuento = tasaDescuento;
    }

    public Double getImporteDescuento() {
        return importeDescuento;
    }

    public void setImporteDescuento(Double importeDescuento) {
        this.importeDescuento = importeDescuento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    

}
