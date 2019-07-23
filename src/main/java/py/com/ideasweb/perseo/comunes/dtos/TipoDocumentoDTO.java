package py.com.ideasweb.perseo.comunes.dtos;

import java.io.Serializable;

public class TipoDocumentoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codTipoDoc;

    private String descripcion;

    private Boolean estado;

    public TipoDocumentoDTO() {
        super();
    }

    public TipoDocumentoDTO(String codTipoDoc) {
        super();
        this.codTipoDoc = codTipoDoc;
    }

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
