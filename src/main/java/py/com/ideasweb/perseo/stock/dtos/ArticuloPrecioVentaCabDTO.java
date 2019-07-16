package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;

import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;

public class ArticuloPrecioVentaCabDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idArticuloPrecioVentaCab;

    private String descripcion;

    private Boolean estado;

    private EmpresaDTO empresa;

    public Integer getIdArticuloPrecioVentaCab() {
        return idArticuloPrecioVentaCab;
    }

    public void setIdArticuloPrecioVentaCab(Integer idArticuloPrecioVentaCab) {
        this.idArticuloPrecioVentaCab = idArticuloPrecioVentaCab;
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

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

}
