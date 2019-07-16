package py.com.ideasweb.perseo.comunes.dtos;

import java.io.Serializable;

import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;

public class DepositoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idDeposito;

    private String descripcion;

    private SucursalDTO sucursal;

    private UsuarioDTO usuario;

    private EmpresaDTO empresa;

    private Boolean estado;

    public DepositoDTO() {
        super();
    }

    public DepositoDTO(Integer idDeposito) {
        super();
        this.idDeposito = idDeposito;
    }

    public Integer getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(Integer idDeposito) {
        this.idDeposito = idDeposito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
