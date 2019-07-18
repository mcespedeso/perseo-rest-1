package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;

import py.com.ideasweb.perseo.stock.dtos.ArticuloDepositoDTO;

public class CompraDetDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCompraDet;

    private CompraCabDTO compraCab;

    private String concepto;

    private Integer cantidad;

    private Double precio;

    private Double gravada;

    private Double exenta;

    private Double ivaPorcentaje;

    private Double ivaImporte;

    private String tipoProvision;

    private ArticuloDepositoDTO articuloDeposito;

    public Integer getIdCompraDet() {
        return idCompraDet;
    }

    public void setIdCompraDet(Integer idCompraDet) {
        this.idCompraDet = idCompraDet;
    }

    public CompraCabDTO getCompraCab() {
        return compraCab;
    }

    public void setCompraCab(CompraCabDTO compraCab) {
        this.compraCab = compraCab;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getGravada() {
        return gravada;
    }

    public void setGravada(Double gravada) {
        this.gravada = gravada;
    }

    public Double getExenta() {
        return exenta;
    }

    public void setExenta(Double exenta) {
        this.exenta = exenta;
    }

    public Double getIvaPorcentaje() {
        return ivaPorcentaje;
    }

    public void setIvaPorcentaje(Double ivaPorcentaje) {
        this.ivaPorcentaje = ivaPorcentaje;
    }

    public Double getIvaImporte() {
        return ivaImporte;
    }

    public void setIvaImporte(Double ivaImporte) {
        this.ivaImporte = ivaImporte;
    }

    public String getTipoProvision() {
        return tipoProvision;
    }

    public void setTipoProvision(String tipoProvision) {
        this.tipoProvision = tipoProvision;
    }

    public ArticuloDepositoDTO getArticuloDeposito() {
        return articuloDeposito;
    }

    public void setArticuloDeposito(ArticuloDepositoDTO articuloDeposito) {
        this.articuloDeposito = articuloDeposito;
    }

}
