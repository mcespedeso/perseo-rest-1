package py.com.ideasweb.perseo.comunes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import py.com.ideasweb.perseo.common.entities.BaseEntity;

@Entity
@Table(name = "tipo_documento")
@JsonInclude(Include.NON_NULL)
public class TipoDocumentoEntity extends BaseEntity {

	@Id
	@Column(name = "cod_tipo_doc")
	private String codTipoDoc;

	private String descripcion;

	private Boolean estado;

    public String getCodTipoDoc() {
        return codTipoDoc;
    }

    public void setCodTipoDoc(String codTipoDoc) {
        this.codTipoDoc = codTipoDoc;
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

	
	
	
}
