package py.com.ideasweb.perseo.tesoreria.entities;

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
@Table(name = "orden_pago_det")
public class OrdenPagoDetEntity extends BaseEntity{

    @Id
    @GenericGenerator(name = "ordenPagoDetSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "orden_pago_det_id_orden_pago_det_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "ordenPagoDetSequenceGenerator")
    @Column(name = "id_orden_pago_det")
    private Integer idOrdenPagoDet;

    private Double importe;

    private String concepto;

    @ManyToOne(targetEntity = OrdenPagoCabEntity.class)
    @JoinColumn(name = "id_orden_pago_cab")
    private OrdenPagoCabEntity ordenpagocab;

    public Integer getIdOrdenPagoDet() {
        return idOrdenPagoDet;
    }

    public void setIdOrdenPagoDet(Integer idOrdenPagoDet) {
        this.idOrdenPagoDet = idOrdenPagoDet;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public OrdenPagoCabEntity getOrdenpagocab() {
        return ordenpagocab;
    }

    public void setOrdenpagocab(OrdenPagoCabEntity ordenpagocab) {
        this.ordenpagocab = ordenpagocab;
    }

}