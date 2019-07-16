package py.com.ideasweb.perseo.tesoreria.dtos;

import java.io.Serializable;

public class ConceptoMovDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
