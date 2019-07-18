package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import py.com.ideasweb.perseo.tesoreria.dtos.CajaDTO;

public class FacturaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idFactura;

    private String estado;

    private CajaDTO caja;

    private Integer establecimiento;

    private Integer puntoExpedicion;

    private Integer nroActual;

    private Integer nroInicial;

    private Integer nroFinal;

    private Date validoDesde;

    private Date validoHasta;

    private String timbrado;

    private Timestamp fechaLog;

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public CajaDTO getCaja() {
        return caja;
    }

    public void setCaja(CajaDTO caja) {
        this.caja = caja;
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

    public Integer getNroActual() {
        return nroActual;
    }

    public void setNroActual(Integer nroActual) {
        this.nroActual = nroActual;
    }

    public Integer getNroInicial() {
        return nroInicial;
    }

    public void setNroInicial(Integer nroInicial) {
        this.nroInicial = nroInicial;
    }

    public Integer getNroFinal() {
        return nroFinal;
    }

    public void setNroFinal(Integer nroFinal) {
        this.nroFinal = nroFinal;
    }

    public Date getValidoDesde() {
        return validoDesde;
    }

    public void setValidoDesde(Date validoDesde) {
        this.validoDesde = validoDesde;
    }

    public Date getValidoHasta() {
        return validoHasta;
    }

    public void setValidoHasta(Date validoHasta) {
        this.validoHasta = validoHasta;
    }

    public String getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
    }

    public Timestamp getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }

}
