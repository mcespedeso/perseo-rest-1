package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;

import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;

public class LineaArticuloDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idLineaArticulo;

    private String descripcion;

    FamiliaDTO familia;

    EmpresaDTO empresa;

    public Integer getIdLineaArticulo() {
        return idLineaArticulo;
    }

    public void setIdLineaArticulo(Integer idLineaArticulo) {
        this.idLineaArticulo = idLineaArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FamiliaDTO getFamilia() {
        return familia;
    }

    public void setFamilia(FamiliaDTO familia) {
        this.familia = familia;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

}
