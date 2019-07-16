package py.com.ideasweb.perseo.transaccion.entities;

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
@Table(name = "estado_compra")
public class EstadoCompraEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "estadoCompraSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "estado_compra_id_estado_compra_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "estadoCompraSequenceGenerator")
    @Column(name = "id_estado_compra")
    private Integer idEstadoCompra;

    private String descripcion;

    public Integer getIdEstadoCompra() {
        return idEstadoCompra;
    }

    public void setIdEstadoCompra(Integer idEstadoCompra) {
        this.idEstadoCompra = idEstadoCompra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
