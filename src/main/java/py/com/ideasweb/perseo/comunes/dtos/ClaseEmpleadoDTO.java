package py.com.ideasweb.perseo.comunes.dtos;

import java.io.Serializable;

public class ClaseEmpleadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idClaseEmpleado;

    private String descripcion;

    private EmpresaDTO empresa;

    public Integer getIdClaseEmpleado() {
        return idClaseEmpleado;
    }

    public void setIdClaseEmpleado(Integer idClaseEmpleado) {
        this.idClaseEmpleado = idClaseEmpleado;
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
