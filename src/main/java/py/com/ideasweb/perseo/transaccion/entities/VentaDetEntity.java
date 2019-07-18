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
import py.com.ideasweb.perseo.comunes.entities.TipoImpuestoEntity;
import py.com.ideasweb.perseo.stock.entities.ArticuloEntity;

@Entity
@Table(name = "venta_det")
public class VentaDetEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "ventaDetSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "venta_det_id_venta_det_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "ventaDetSequenceGenerator")
    @Column(name = "id_venta_det")
    private Integer idVentaDet;

    @ManyToOne(targetEntity = VentaCabEntity.class)
    @JoinColumn(name = "id_venta_cab")
    private VentaCabEntity ventaCab;;

    @ManyToOne(targetEntity = ArticuloEntity.class)
    @JoinColumn(name = "id_articulo")
    private ArticuloEntity articulo;

    private Double cantidad;

    private Double precioCosto;

    private Double precioVenta;

    @ManyToOne(targetEntity = TipoImpuestoEntity.class)
    @JoinColumn(name = "id_tipo_impuesto")
    private TipoImpuestoEntity tipoImpuesto;

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

    public VentaCabEntity getVentaCab() {
        return ventaCab;
    }

    public void setVentaCab(VentaCabEntity ventaCab) {
        this.ventaCab = ventaCab;
    }

    public ArticuloEntity getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloEntity articulo) {
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

    public TipoImpuestoEntity getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuestoEntity tipoImpuesto) {
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
