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

import py.com.ideasweb.perseo.common.entities.BaseEntity;

@Entity
@Table(name = "articulo_transferencia_det")
public class ArticuloTransferenciaDetEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "articuloTransferenciaDetSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "articulotransferenciadet_id_articulo_transferencia_det_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "articuloTransferenciaDetSequenceGenerator")

    @Column(name = "id_articulo_transferencia_det")
    private Integer idArticuloTransferenciaDet;

    private Integer cantidadContado;

    private Integer cantidadRecibido;

    @ManyToOne(targetEntity = ArticuloTransferenciaCabEntity.class)
    @JoinColumn(name = "id_articulo_transferencia_cab")
    private ArticuloTransferenciaCabEntity articuloTransferenciaCab;

    @ManyToOne(targetEntity = ArticuloEntity.class)
    @JoinColumn(name = "id_articulo", nullable = false)
    private ArticuloEntity articulo;

    public Integer getIdArticuloTransferenciaDet() {
        return idArticuloTransferenciaDet;
    }

    public void setIdArticuloTransferenciaDet(
            Integer idArticuloTransferenciaDet) {
        this.idArticuloTransferenciaDet = idArticuloTransferenciaDet;
    }

    public Integer getCantidadContado() {
        return cantidadContado;
    }

    public void setCantidadContado(Integer cantidadContado) {
        this.cantidadContado = cantidadContado;
    }

    public Integer getCantidadRecibido() {
        return cantidadRecibido;
    }

    public void setCantidadRecibido(Integer cantidadRecibido) {
        this.cantidadRecibido = cantidadRecibido;
    }

    public ArticuloTransferenciaCabEntity getArticuloTransferenciaCab() {
        return articuloTransferenciaCab;
    }

    public void setArticuloTransferenciaCab(
            ArticuloTransferenciaCabEntity articuloTransferenciaCab) {
        this.articuloTransferenciaCab = articuloTransferenciaCab;
    }

    public ArticuloEntity getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloEntity articulo) {
        this.articulo = articulo;
    }

}
