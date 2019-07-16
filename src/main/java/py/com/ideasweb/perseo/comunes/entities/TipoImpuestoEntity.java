package py.com.ideasweb.perseo.comunes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import py.com.ideasweb.perseo.common.entities.BaseEntity;

@Entity
@Table(name = "tipo_impuesto")
@JsonInclude(Include.NON_NULL)
public class TipoImpuestoEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "tipoImpuestoSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "tipo_impuesto_id_tipo_impuesto_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "tipoImpuestoSequenceGenerator")
    @Column(name = "id_tipo_impuesto")
    private Integer idTipoImpuesto;

    private String descripcion;

    private Double dividendo;

    private Double tasa;

    private Boolean estado;

    public TipoImpuestoEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getIdTipoImpuesto() {
        return idTipoImpuesto;
    }

    public void setIdTipoImpuesto(Integer idTipoImpuesto) {
        this.idTipoImpuesto = idTipoImpuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getDividendo() {
        return dividendo;
    }

    public void setDividendo(Double dividendo) {
        this.dividendo = dividendo;
    }

    public Double getTasa() {
        return tasa;
    }

    public void setTasa(Double tasa) {
        this.tasa = tasa;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
