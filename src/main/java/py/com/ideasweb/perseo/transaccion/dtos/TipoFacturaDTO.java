package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;

public class TipoFacturaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
