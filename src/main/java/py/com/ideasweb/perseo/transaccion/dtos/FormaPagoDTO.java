package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;

public class FormaPagoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idFormaPago;

    private String descripcion;

    private String tipo;

    private Boolean estado;

    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
