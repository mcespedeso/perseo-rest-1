package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;

public class HistoricoPrecioVentaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date fecha;

    private Timestamp fechaLog;

    private String concepto;

    private Double precioCosto;

    private Double precioVenta;

    private Double porcentaje;

    private UsuarioDTO usuario;

    private EmpresaDTO empresa;

    private ArticuloPrecioVentaDetDTO articuloPrecioVentaDet;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Timestamp getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
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

    public ArticuloPrecioVentaDetDTO getArticuloPrecioVentaDet() {
        return articuloPrecioVentaDet;
    }

    public void setArticuloPrecioVentaDet(
            ArticuloPrecioVentaDetDTO articuloPrecioVentaDet) {
        this.articuloPrecioVentaDet = articuloPrecioVentaDet;
    }

}
