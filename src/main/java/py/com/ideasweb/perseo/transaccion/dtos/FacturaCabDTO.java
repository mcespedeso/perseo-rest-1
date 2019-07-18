package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import py.com.ideasweb.perseo.comunes.dtos.ClienteDTO;
import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.tesoreria.dtos.CajaDTO;
import py.com.ideasweb.perseo.tesoreria.dtos.MonedaDTO;

public class FacturaCabDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idFacturaCab;

    private Date fecha;

    private Timestamp fechaLog;

    private ClienteDTO cliente;

    private Boolean estado;

    private MonedaDTO moneda;

    private SucursalDTO sucursal;

    private Integer establecimiento;

    private Integer puntoExpedicion;

    private Integer nroFactura;

    private Double importe;

    private Double saldo;

    private String observacion;

    private Boolean impreso;

    private MetodoCobroDTO metodoCobro;

    private EmpresaDTO empresa;

    private TipoFacturaDTO tipoFactura;

    private Double cotizacion;

    private CajaDTO caja;

    private UsuarioDTO usuario;

    private Timestamp fechaAnulacion;

    private VentaCabDTO ventaCab;

    private Integer timbrado;

    private Date vigencia_Timbrado;

    private TurnoDTO turno;

    public Integer getIdFacturaCab() {
        return idFacturaCab;
    }

    public void setIdFacturaCab(Integer idFacturaCab) {
        this.idFacturaCab = idFacturaCab;
    }

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

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public MonedaDTO getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaDTO moneda) {
        this.moneda = moneda;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
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

    public Integer getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(Integer nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getImpreso() {
        return impreso;
    }

    public void setImpreso(Boolean impreso) {
        this.impreso = impreso;
    }

    public MetodoCobroDTO getMetodoCobro() {
        return metodoCobro;
    }

    public void setMetodoCobro(MetodoCobroDTO metodoCobro) {
        this.metodoCobro = metodoCobro;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public TipoFacturaDTO getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(TipoFacturaDTO tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Double getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public CajaDTO getCaja() {
        return caja;
    }

    public void setCaja(CajaDTO caja) {
        this.caja = caja;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Timestamp getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Timestamp fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public VentaCabDTO getVentaCab() {
        return ventaCab;
    }

    public void setVentaCab(VentaCabDTO ventaCab) {
        this.ventaCab = ventaCab;
    }

    public Integer getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(Integer timbrado) {
        this.timbrado = timbrado;
    }

    public Date getVigencia_Timbrado() {
        return vigencia_Timbrado;
    }

    public void setVigencia_Timbrado(Date vigencia_Timbrado) {
        this.vigencia_Timbrado = vigencia_Timbrado;
    }

    public TurnoDTO getTurno() {
        return turno;
    }

    public void setTurno(TurnoDTO turno) {
        this.turno = turno;
    }

}
