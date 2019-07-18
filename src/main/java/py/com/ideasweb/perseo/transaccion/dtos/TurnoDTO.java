package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.tesoreria.dtos.CajaDTO;

public class TurnoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idTurno;

    private Date fecha;

    private Timestamp fechaApertura;

    private Timestamp fechaCierre;

    private SucursalDTO sucursal;

    private UsuarioDTO usuario;

    private CajaDTO caja;

    private Date fechaUltApertura;

    private Date fechaUltCierre;

    private Double totalEfectivo;

    private Double totalCheque;

    private Double totalTarjeta;

    private Double cantVenta;

    private Double cantVentaNula;

    private Double cantCompra;

    private Double cantCompraNula;

    private Boolean estado;

    private String tipoTurno;

    private EmpresaDTO empresa;

    private Timestamp fechaLog;

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Timestamp getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Timestamp fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Timestamp getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Timestamp fechaCierre) {
        this.fechaCierre = fechaCierre;
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

    public CajaDTO getCaja() {
        return caja;
    }

    public void setCaja(CajaDTO caja) {
        this.caja = caja;
    }

    public Date getFechaUltApertura() {
        return fechaUltApertura;
    }

    public void setFechaUltApertura(Date fechaUltApertura) {
        this.fechaUltApertura = fechaUltApertura;
    }

    public Date getFechaUltCierre() {
        return fechaUltCierre;
    }

    public void setFechaUltCierre(Date fechaUltCierre) {
        this.fechaUltCierre = fechaUltCierre;
    }

    public Double getTotalEfectivo() {
        return totalEfectivo;
    }

    public void setTotalEfectivo(Double totalEfectivo) {
        this.totalEfectivo = totalEfectivo;
    }

    public Double getTotalCheque() {
        return totalCheque;
    }

    public void setTotalCheque(Double totalCheque) {
        this.totalCheque = totalCheque;
    }

    public Double getTotalTarjeta() {
        return totalTarjeta;
    }

    public void setTotalTarjeta(Double totalTarjeta) {
        this.totalTarjeta = totalTarjeta;
    }

    public Double getCantVenta() {
        return cantVenta;
    }

    public void setCantVenta(Double cantVenta) {
        this.cantVenta = cantVenta;
    }

    public Double getCantVentaNula() {
        return cantVentaNula;
    }

    public void setCantVentaNula(Double cantVentaNula) {
        this.cantVentaNula = cantVentaNula;
    }

    public Double getCantCompra() {
        return cantCompra;
    }

    public void setCantCompra(Double cantCompra) {
        this.cantCompra = cantCompra;
    }

    public Double getCantCompraNula() {
        return cantCompraNula;
    }

    public void setCantCompraNula(Double cantCompraNula) {
        this.cantCompraNula = cantCompraNula;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public Timestamp getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }
    
    

}
