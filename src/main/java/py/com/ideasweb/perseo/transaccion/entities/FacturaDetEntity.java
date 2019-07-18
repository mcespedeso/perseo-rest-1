package py.com.ideasweb.perseo.transaccion.entities;

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
import py.com.ideasweb.perseo.stock.entities.ArticuloEntity;

@Entity
@Table(name = "factura_det")
public class FacturaDetEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "facturaDetSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "factura_det_id_factura_det_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "facturaDetSequenceGenerator")
    @Column(name = "id_factura_det")
    private Integer idFacturaDet;

    @ManyToOne(targetEntity = FacturaCabEntity.class)
    @JoinColumn(name = "id_factura_cab")
    private FacturaCabEntity facturaCab;

    private String concepto;

    private Double cantidad;

    private Double exenta;

    private Double grabada5;

    private Double grabada10;

    private Double iva5;

    private Double iva10;

    private Double precioVenta;

    private Double total;

    private Double descuento;

    private Double precioCosto;

    @ManyToOne(targetEntity = ArticuloEntity.class)
    @JoinColumn(name = "id_articulo", nullable = false)
    private ArticuloEntity articulo;

    public Integer getIdFacturaDet() {
        return idFacturaDet;
    }

    public void setIdFacturaDet(Integer idFacturaDet) {
        this.idFacturaDet = idFacturaDet;
    }

    public FacturaCabEntity getFacturaCab() {
        return facturaCab;
    }

    public void setFacturaCab(FacturaCabEntity facturaCab) {
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

    public Double getGrabada5() {
        return grabada5;
    }

    public void setGrabada5(Double grabada5) {
        this.grabada5 = grabada5;
    }

    public Double getGrabada10() {
        return grabada10;
    }

    public void setGrabada10(Double grabada10) {
        this.grabada10 = grabada10;
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

    public ArticuloEntity getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloEntity articulo) {
        this.articulo = articulo;
    };

}
