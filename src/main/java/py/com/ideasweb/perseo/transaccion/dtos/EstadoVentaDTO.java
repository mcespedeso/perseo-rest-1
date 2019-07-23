package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;

public class EstadoVentaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idEstadoVenta;

    private String descripcion;

    public EstadoVentaDTO() {
        super();
    }

    public EstadoVentaDTO(Integer idEstadoVenta) {
        super();
        this.idEstadoVenta = idEstadoVenta;
    }

    public Integer getIdEstadoVenta() {
        return idEstadoVenta;
    }

    public void setIdEstadoVenta(Integer idEstadoVenta) {
        this.idEstadoVenta = idEstadoVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
