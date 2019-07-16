package py.com.ideasweb.perseo.comunes.dtos;

import java.io.Serializable;

public class SucursalDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idSucursal;

    private String descripcion;

    private String codigo;

    private String telefono1;

    private String telefono2;

    private String ciudad;

    private EmpresaDTO empresa;

    private Boolean matriz;

    private Boolean estado;

    
    public SucursalDTO() {
        super();
    }
    
    

    public SucursalDTO(Integer idSucursal) {
        super();
        this.idSucursal = idSucursal;
    }



    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public Boolean getMatriz() {
        return matriz;
    }

    public void setMatriz(Boolean matriz) {
        this.matriz = matriz;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
