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
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;

@Entity
@Table(name = "metodo_cobro")
public class MetodoCobroEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "metodoCobroSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "metodocobro_id_metodo_cobro_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "metodoCobroSequenceGenerator")
    @Column(name = "id_metodo_cobro")
    private Integer idMetodoCobro;

    private String descripcion;

    private Boolean estado;

    private Double minimoComision;

    private Double maximoComision;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

    public Integer getIdMetodoCobro() {
        return idMetodoCobro;
    }

    public void setIdMetodoCobro(Integer idMetodoCobro) {
        this.idMetodoCobro = idMetodoCobro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Double getMinimoComision() {
        return minimoComision;
    }

    public void setMinimoComision(Double minimoComision) {
        this.minimoComision = minimoComision;
    }

    public Double getMaximoComision() {
        return maximoComision;
    }

    public void setMaximoComision(Double maximoComision) {
        this.maximoComision = maximoComision;
    }

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

}
