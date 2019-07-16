package py.com.ideasweb.perseo.stock.entities;

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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "articulo_precio_venta_det")
public class ArticuloPrecioVentaDetEntity {

    @Id
    @GenericGenerator(name = "articuloPrecioVentaDetSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "articulo_precio_venta_det_id_articulo_precio_venta_det_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "articuloPrecioVentaDetSequenceGenerator")
    @Column(name = "id_articulo_precio_venta_det")
    private Integer idArticuloPrecioVentaDet;

    @ManyToOne(targetEntity = ArticuloPrecioVentaCabEntity.class)
    @JoinColumn(name = "id_articulo_precio_venta_cab")
    ArticuloPrecioVentaCabEntity articuloPrecioVentaCab;

    @ManyToOne(targetEntity = ArticuloEntity.class)
    @JoinColumn(name = "id_articulo")
    ArticuloEntity articulo;

    private Double precio;

    public Integer getIdArticuloPrecioVentaDet() {
        return idArticuloPrecioVentaDet;
    }

    public void setIdArticuloPrecioVentaDet(Integer idArticuloPrecioVentaDet) {
        this.idArticuloPrecioVentaDet = idArticuloPrecioVentaDet;
    }

    public ArticuloPrecioVentaCabEntity getArticuloPrecioVentaCab() {
        return articuloPrecioVentaCab;
    }

    public void setArticuloPrecioVentaCab(
            ArticuloPrecioVentaCabEntity articuloPrecioVentaCab) {
        this.articuloPrecioVentaCab = articuloPrecioVentaCab;
    }

    public ArticuloEntity getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloEntity articulo) {
        this.articulo = articulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
