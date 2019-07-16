package py.com.ideasweb.perseo.app.facturacion.model;

import java.sql.Date;
import java.sql.Timestamp;

public class TalonarioLite {

    private Integer idTalonario;
    private Timestamp fechaLog;
    private String timbrado;
    private Date validoDesde;
    private Date validoHasta;
    private Integer numeroInicial;
    private Integer numeroFinal;
    private Integer establecimiento;
    private Integer puntoExpedicion;
    private Integer numeroActual;
    
    public Integer getIdTalonario() {
        return idTalonario;
    }
    public void setIdTalonario(Integer idTalonario) {
        this.idTalonario = idTalonario;
    }
    public Timestamp getFechaLog() {
        return fechaLog;
    }
    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }
    public String getTimbrado() {
        return timbrado;
    }
    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
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
    public Integer getNumeroInicial() {
        return numeroInicial;
    }
    public void setNumeroInicial(Integer numeroInicial) {
        this.numeroInicial = numeroInicial;
    }
    public Integer getNumeroFinal() {
        return numeroFinal;
    }
    public void setNumeroFinal(Integer numeroFinal) {
        this.numeroFinal = numeroFinal;
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
    public Integer getNumeroActual() {
        return numeroActual;
    }
    public void setNumeroActual(Integer numeroActual) {
        this.numeroActual = numeroActual;
    }
    
    
    
}
