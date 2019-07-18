package py.com.ideasweb.perseo.transaccion.entities;

import java.sql.Date;

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
@Table(name = "factura_plazo")
public class FacturaPlazoEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "facturaPlazoSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "factura_plazo_id_factura_plazo_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "facturaPlazoSequenceGenerator")
    @Column(name = "id_factura_plazo")
    private Integer idFacturaPlazo;

    @ManyToOne(targetEntity = FacturaCabEntity.class)
    @JoinColumn(name = "id_factura_cab")
    private FacturaCabEntity facturaCab;

    private Date fechaVencimiento;

    public Integer getIdFacturaPlazo() {
        return idFacturaPlazo;
    }

    public void setIdFacturaPlazo(Integer idFacturaPlazo) {
        this.idFacturaPlazo = idFacturaPlazo;
    }

    public FacturaCabEntity getFacturaCab() {
        return facturaCab;
    }

    public void setFacturaCab(FacturaCabEntity facturaCab) {
        this.facturaCab = facturaCab;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
