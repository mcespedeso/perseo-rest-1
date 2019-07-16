package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;

import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;

public class MetodoCobroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idMetodoCobro;

    private String descripcion;

    private Boolean estado;

    private Double minimoComision;

    private Double maximoComision;

    private EmpresaDTO empresa;

    public Integer getIdMetodoCobro() {
        return idMetodoCobro;
    }

    public void setIdMetodoCobro(Integer idMetodoCobro) {
        this.idMetodoCobro = idMetodoCobro;
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

    public Double getMinimoComision() {
        return minimoComision;
    }

    public void setMinimoComision(Double minimoComision) {
        this.minimoComision = minimoComision;
    }

    public Double getMaximoComision() {
        return maximoComision;
    }

    public void setMaximoComision(Double maximoComision) {
        this.maximoComision = maximoComision;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

}
