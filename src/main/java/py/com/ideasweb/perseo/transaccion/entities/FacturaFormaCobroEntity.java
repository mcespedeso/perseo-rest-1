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

@Entity
@Table(name = "factura_forma_cobro")
public class FacturaFormaCobroEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "facturaFormaCobroSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "facturaformacobro_id_factura_forma_cobro_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "facturaFormaCobroSequenceGenerator")
    @Column(name = "id_factura_forma_cobro")
    private Integer idFacturaFormaCobro;

    private Double importe;

    private Boolean estado;

    @ManyToOne(targetEntity = FacturaCabEntity.class)
    @JoinColumn(name = "id_factura_cab")
    private FacturaCabEntity facturaCab;

    private String refrencia;

    public Integer getIdFacturaFormaCobro() {
        return idFacturaFormaCobro;
    }

    public void setIdFacturaFormaCobro(Integer idFacturaFormaCobro) {
        this.idFacturaFormaCobro = idFacturaFormaCobro;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public FacturaCabEntity getFacturaCab() {
        return facturaCab;
    }

    public void setFacturaCab(FacturaCabEntity facturaCab) {
        this.facturaCab = facturaCab;
    }

    public String getRefrencia() {
        return refrencia;
    }

    public void setRefrencia(String refrencia) {
        this.refrencia = refrencia;
    }

}
