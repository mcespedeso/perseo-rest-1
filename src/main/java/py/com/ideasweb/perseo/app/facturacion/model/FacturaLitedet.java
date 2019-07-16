package py.com.ideasweb.perseo.app.facturacion.model;

public class FacturaLitedet {

    private int idFacturaDet;
    private String concepto;//nombre del articulo
    private Double cantidad;
    private Double precioVenta;
    private Double tasaIva;
    private Double impuesto;
    private Integer idArticulo;
    private Integer idFacturaCab;
    private Double subTotal;
    
    public Double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
    public int getIdFacturaDet() {
        return idFacturaDet;
    }
    public void setIdFacturaDet(int idFacturaDet) {
        this.idFacturaDet = idFacturaDet;
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
    public Double getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
    public Double getTasaIva() {
        return tasaIva;
    }
    public void setTasaIva(Double tasaIva) {
        this.tasaIva = tasaIva;
    }
    public Double getImpuesto() {
        return impuesto;
    }
    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }
    public Integer getIdArticulo() {
        return idArticulo;
    }
    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }
    public Integer getIdFacturaCab() {
        return idFacturaCab;
    }
    public void setIdFacturaCab(Integer idFacturaCab) {
        this.idFacturaCab = idFacturaCab;
    }
    
}
