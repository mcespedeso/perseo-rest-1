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
@Table(name = "tipo_factura")
public class TipoFacturaEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "tipoFacturaSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "tipo_factura_id_tipo_factura_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "tipoFacturaSequenceGenerator")
    @Column(name = "id_tipo_factura")
    private Integer idTipoFactura;

    private String descripcion;

    public Integer getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(Integer idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
