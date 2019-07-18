package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import py.com.ideasweb.perseo.comunes.dtos.ClienteDTO;
import py.com.ideasweb.perseo.comunes.dtos.DepositoDTO;
import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.tesoreria.dtos.MonedaDTO;

public class VentaCabDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idVentaCab;

    private Date fecha;

    private Timestamp fechaLog;

    private Date fechaFacturacion;

    private UsuarioDTO usuario;

    private DepositoDTO deposito;

    private EstadoVentaDTO estadoVenta;

    private ClienteDTO cliente;

    private MonedaDTO moneda;

    private FormaPagoDTO formaPago;

    private SucursalDTO sucursal;

    private EmpresaDTO empresa;

    private Double importe;

    private Double impuesto;

    private Double cantidadTotal;

    private Integer nroLoteVenta;

    private Double promedioDescuento;

    private String observacion;

    private Boolean retenido;

    private String motivoRetencion;

    private MetodoCobroDTO metodoCobro;

    private TurnoDTO turno;

    public Integer getIdVentaCab() {
        return idVentaCab;
    }

    public void setIdVentaCab(Integer idVentaCab) {
        this.idVentaCab = idVentaCab;
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

    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public DepositoDTO getDeposito() {
        return deposito;
    }

    public void setDeposito(DepositoDTO deposito) {
        this.deposito = deposito;
    }

    public EstadoVentaDTO getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVentaDTO estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public MonedaDTO getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaDTO moneda) {
        this.moneda = moneda;
    }

    public FormaPagoDTO getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPagoDTO formaPago) {
        this.formaPago = formaPago;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Double cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public Integer getNroLoteVenta() {
        return nroLoteVenta;
    }

    public void setNroLoteVenta(Integer nroLoteVenta) {
        this.nroLoteVenta = nroLoteVenta;
    }

    public Double getPromedioDescuento() {
        return promedioDescuento;
    }

    public void setPromedioDescuento(Double promedioDescuento) {
        this.promedioDescuento = promedioDescuento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getRetenido() {
        return retenido;
    }

    public void setRetenido(Boolean retenido) {
        this.retenido = retenido;
    }

    public String getMotivoRetencion() {
        return motivoRetencion;
    }

    public void setMotivoRetencion(String motivoRetencion) {
        this.motivoRetencion = motivoRetencion;
    }

    public MetodoCobroDTO getMetodoCobro() {
        return metodoCobro;
    }

    public void setMetodoCobro(MetodoCobroDTO metodoCobro) {
        this.metodoCobro = metodoCobro;
    }

    public TurnoDTO getTurno() {
        return turno;
    }

    public void setTurno(TurnoDTO turno) {
        this.turno = turno;
    }

}
