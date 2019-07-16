package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;

import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;

public class FamiliaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idFamilia;

    private String descripcion;

    private Boolean estado;

    private Double porcentajeGanancia;

    private EmpresaDTO empresa;

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
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

    public Double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcentajeGanancia(Double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
