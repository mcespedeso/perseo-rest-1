package py.com.ideasweb.perseo.app.facturacion.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FacturaLitecab {

    private int idFacturaCab;
    private Date fecha;
    private Timestamp fechalog;
    private Integer idCliente;
    private Integer idUsuario;
    private String nroDocumentoCliente;
    private String nombreCliente;
    private String direccionCliente;
    private String telefonoCliente;
    private String timbrado;
    private Integer establecimiento;// 001
    private Integer puntoExpedicion;// 001
    private Integer numeroFactura;// 0000001
    private String tipoFactura;// CONTADO-CREDITO
    private Double importe;
    private Boolean estado;
    private Boolean sincronizadoCore;
    private Timestamp fechaHoraSincronizacionCore;
    private Integer idEmpresa;

    private List<FacturaLitedet> facturadet;

    public int getIdFacturaCab() {
        return idFacturaCab;
    }

    public void setIdFacturaCab(int idFacturaCab) {
        this.idFacturaCab = idFacturaCab;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Timestamp getFechalog() {
        return fechalog;
    }

    public void setFechalog(Timestamp fechalog) {
        this.fechalog = fechalog;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNroDocumentoCliente() {
        return nroDocumentoCliente;
    }

    public void setNroDocumentoCliente(String nroDocumentoCliente) {
        this.nroDocumentoCliente = nroDocumentoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
    }

    public Integer getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Integer establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Integer getPuntoExpedicion() {
        return puntoExpedicion;
    }

    public void setPuntoExpedicion(Integer puntoExpedicion) {
        this.puntoExpedicion = puntoExpedicion;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getSincronizadoCore() {
        return sincronizadoCore;
    }

    public void setSincronizadoCore(Boolean sincronizadoCore) {
        this.sincronizadoCore = sincronizadoCore;
    }

    public Timestamp getFechaHoraSincronizacionCore() {
        return fechaHoraSincronizacionCore;
    }

    public void setFechaHoraSincronizacionCore(
            Timestamp fechaHoraSincronizacionCore) {
        this.fechaHoraSincronizacionCore = fechaHoraSincronizacionCore;
    }

    public List<FacturaLitedet> getFacturadet() {
        return facturadet;
    }

    public void setFacturadet(List<FacturaLitedet> facturadet) {
        this.facturadet = facturadet;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    

}
