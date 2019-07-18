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
import py.com.ideasweb.perseo.stock.entities.ArticuloDepositoEntity;

@Entity
@Table(name = "compra_det")
public class CompraDetEntity extends BaseEntity{
    
    @Id
    @GenericGenerator(name = "compraDetSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "compradet_id_compra_det_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "compraDetSequenceGenerator")
    @Column(name = "id_compra_det")
    private Integer idCompraDet;
    
    
    @ManyToOne(targetEntity = CompraCabEntity.class)
    @JoinColumn(name = "id_compra_cab")
    private CompraCabEntity compraCab;
    
    
    private String concepto;
    
    private Integer cantidad;
    
    private Double precio;

    private Double gravada;
    
    private Double exenta;

    private Double ivaPorcentaje;

    private Double ivaImporte;
    
    private String tipoProvision;
    
    @ManyToOne(targetEntity = ArticuloDepositoEntity.class)
    @JoinColumn(name = "id_articulo_deposito")
    private ArticuloDepositoEntity articuloDeposito;

    public Integer getIdCompraDet() {
        return idCompraDet;
    }

    public void setIdCompraDet(Integer idCompraDet) {
        this.idCompraDet = idCompraDet;
    }

    public CompraCabEntity getCompraCab() {
        return compraCab;
    }

    public void setCompraCab(CompraCabEntity compraCab) {
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

    public ArticuloDepositoEntity getArticuloDeposito() {
        return articuloDeposito;
    }

    public void setArticuloDeposito(ArticuloDepositoEntity articuloDeposito) {
        this.articuloDeposito = articuloDeposito;
    }
    
    


}
