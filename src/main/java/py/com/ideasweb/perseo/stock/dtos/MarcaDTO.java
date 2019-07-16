package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;

import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;

public class MarcaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idMarca;

    private String descripcion;

    private EmpresaDTO empresa;

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

}
