package py.com.ideasweb.perseo.comunes.dtos;

import java.io.Serializable;

public class TipoImpuestoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idTipoImpuesto;

    private String descripcion;

    private Double dividendo;

    private Double tasa;

    private Boolean estado;
    
    

    public TipoImpuestoDTO() {
        super();
    }
    
    

    public Integer getIdTipoImpuesto() {
        return idTipoImpuesto;
    }

    public void setIdTipoImpuesto(Integer idTipoImpuesto) {
        this.idTipoImpuesto = idTipoImpuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getDividendo() {
        return dividendo;
    }

    public void setDividendo(Double dividendo) {
        this.dividendo = dividendo;
    }

    public Double getTasa() {
        return tasa;
    }

    public void setTasa(Double tasa) {
        this.tasa = tasa;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
