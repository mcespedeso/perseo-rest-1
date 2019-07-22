package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.comunes.dtos.ProveedorDTO;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.tesoreria.dtos.MonedaDTO;

public class CompraCabDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCompraCab;

    private Date fecha;

    private Timestamp fechaLog;

    private String tipo;

    private String comprobante;

    private ProveedorDTO proveedor;

    private MonedaDTO moneda;

    private EmpresaDTO empresa;

    private SucursalDTO sucursal;

    private UsuarioDTO usuario;

    private Double importe;

    private Double pagado;

    private EstadoCompraDTO estadoCompra;

    private Double gravada10;

    private Double gravada5;

    private Double iva10;

    private Double iva5;

    private Double exenta;

    private String condicion;

    private String timbrado;

    private Date fecVencTimbrado;

    private Double cotizacion;

    private Integer cantidadCuota;

    private String observaciones;

    private TurnoDTO turno;
    
    List<CompraDetDTO> detalles;

    public Integer getIdCompraCab() {
        return idCompraCab;
    }

    public void setIdCompraCab(Integer idCompraCab) {
        this.idCompraCab = idCompraCab;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }

    public MonedaDTO getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaDTO moneda) {
        this.moneda = moneda;
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getPagado() {
        return pagado;
    }

    public void setPagado(Double pagado) {
        this.pagado = pagado;
    }

    public EstadoCompraDTO getEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(EstadoCompraDTO estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    public Double getGravada10() {
        return gravada10;
    }

    public void setGravada10(Double gravada10) {
        this.gravada10 = gravada10;
    }

    public Double getGravada5() {
        return gravada5;
    }

    public void setGravada5(Double gravada5) {
        this.gravada5 = gravada5;
    }

    public Double getIva10() {
        return iva10;
    }

    public void setIva10(Double iva10) {
        this.iva10 = iva10;
    }

    public Double getIva5() {
        return iva5;
    }

    public void setIva5(Double iva5) {
        this.iva5 = iva5;
    }

    public Double getExenta() {
        return exenta;
    }

    public void setExenta(Double exenta) {
        this.exenta = exenta;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
    }

    public Date getFecVencTimbrado() {
        return fecVencTimbrado;
    }

    public void setFecVencTimbrado(Date fecVencTimbrado) {
        this.fecVencTimbrado = fecVencTimbrado;
    }

    public Double getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Integer getCantidadCuota() {
        return cantidadCuota;
    }

    public void setCantidadCuota(Integer cantidadCuota) {
        this.cantidadCuota = cantidadCuota;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public TurnoDTO getTurno() {
        return turno;
    }

    public void setTurno(TurnoDTO turno) {
        this.turno = turno;
    }

    public List<CompraDetDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<CompraDetDTO> detalles) {
        this.detalles = detalles;
    }

    
}
