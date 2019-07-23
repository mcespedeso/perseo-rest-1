package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;

import py.com.ideasweb.perseo.stock.dtos.ArticuloDTO;

public class FacturaDetDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idFacturaDet;

    private FacturaCabDTO facturaCab;

    private String concepto;

    private Double cantidad;

    private Double exenta;

    private Double gravada5;

    private Double gravada10;

    private Double iva5;

    private Double iva10;

    private Double precioVenta;

    private Double total;

    private Double descuento;

    private Double precioCosto;

    private ArticuloDTO articulo;

    public Integer getIdFacturaDet() {
        return idFacturaDet;
    }

    public void setIdFacturaDet(Integer idFacturaDet) {
        this.idFacturaDet = idFacturaDet;
    }

    public FacturaCabDTO getFacturaCab() {
        return facturaCab;
    }

    public void setFacturaCab(FacturaCabDTO facturaCab) {
        this.facturaCab = facturaCab;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getExenta() {
        return exenta;
    }

    public void setExenta(Double exenta) {
        this.exenta = exenta;
    }

    public Double getGravada5() {
        return gravada5;
    }

    public void setGravada5(Double grabada5) {
        this.gravada5 = grabada5;
    }

    public Double getGravada10() {
        return gravada10;
    }

    public void setGravada10(Double grabada10) {
        this.gravada10 = grabada10;
    }

    public Double getIva5() {
        return iva5;
    }

    public void setIva5(Double iva5) {
        this.iva5 = iva5;
    }

    public Double getIva10() {
        return iva10;
    }

    public void setIva10(Double iva10) {
        this.iva10 = iva10;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public ArticuloDTO getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloDTO articulo) {
        this.articulo = articulo;
    }

}
