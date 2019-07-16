package py.com.ideasweb.perseo.tesoreria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import py.com.ideasweb.perseo.common.entities.BaseEntity;

@Entity
@Table(name = "concepto_mov")
public class ConceptoMovEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "conceptoMovSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "concepto_mov_id_concepto_mov_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "conceptoMovSequenceGenerator")
    @Column(name = "id_concepto_mov")
    private Integer idConceptoMov;

    private String descripcion;

    private String tipo;

    public Integer getIdConceptoMov() {
        return idConceptoMov;
    }

    public void setIdConceptoMov(Integer idConceptoMov) {
        this.idConceptoMov = idConceptoMov;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
