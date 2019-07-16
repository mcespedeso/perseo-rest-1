package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;

public class EstadoCompraDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
