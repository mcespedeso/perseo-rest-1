package py.com.ideasweb.perseo.tesoreria.dtos;

import java.io.Serializable;
import java.sql.Date;

import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;

public class OrdenPagoCabDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idOrdenPagoCab;

    private Date fecha;

    private String beneficiario;

    private String concepto;

    private String comentario;

    private UsuarioDTO usuario;

    private MonedaDTO moneda;

    private Double importe;

    private Double cotizacion;

    private String estado;

    private Date fechaPago;

    private Boolean retenido;

    private Double importeRetenido;

    private EmpresaDTO empresa;

    private SucursalDTO sucursal;

    public Integer getIdOrdenPagoCab() {
        return idOrdenPagoCab;
    }

    public void setIdOrdenPagoCab(Integer idOrdenPagoCab) {
        this.idOrdenPagoCab = idOrdenPagoCab;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public MonedaDTO getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaDTO moneda) {
        this.moneda = moneda;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Boolean getRetenido() {
        return retenido;
    }

    public void setRetenido(Boolean retenido) {
        this.retenido = retenido;
    }

    public Double getImporteRetenido() {
        return importeRetenido;
    }

    public void setImporteRetenido(Double importeRetenido) {
        this.importeRetenido = importeRetenido;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

}
