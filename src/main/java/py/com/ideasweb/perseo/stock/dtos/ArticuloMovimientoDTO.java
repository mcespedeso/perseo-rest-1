package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import py.com.ideasweb.perseo.comunes.dtos.DepositoDTO;
import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.tesoreria.dtos.ConceptoMovDTO;
import py.com.ideasweb.perseo.transaccion.dtos.CompraCabDTO;
import py.com.ideasweb.perseo.transaccion.dtos.TurnoDTO;
import py.com.ideasweb.perseo.transaccion.dtos.VentaCabDTO;

public class ArticuloMovimientoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idArticuloMovimiento;

    private Date fecha;

    private Timestamp fechaLog;

    private ArticuloDTO articulo;;

    private DepositoDTO deposito;

    private ConceptoMovDTO conceptoMov;

    private SucursalDTO sucursal;

    private UsuarioDTO usuario;

    private TurnoDTO turno;

    private VentaCabDTO ventaCab;

    private CompraCabDTO compraCab;

    private Double cantidad;

    private String columna;

    private String obs;

    private EmpresaDTO empresa;

    public Integer getIdArticuloMovimiento() {
        return idArticuloMovimiento;
    }

    public void setIdArticuloMovimiento(Integer idArticuloMovimiento) {
        this.idArticuloMovimiento = idArticuloMovimiento;
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

    public ArticuloDTO getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloDTO articulo) {
        this.articulo = articulo;
    }

    public DepositoDTO getDeposito() {
        return deposito;
    }

    public void setDeposito(DepositoDTO deposito) {
        this.deposito = deposito;
    }

    public ConceptoMovDTO getConceptoMov() {
        return conceptoMov;
    }

    public void setConceptoMov(ConceptoMovDTO conceptoMov) {
        this.conceptoMov = conceptoMov;
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

    public TurnoDTO getTurno() {
        return turno;
    }

    public void setTurno(TurnoDTO turno) {
        this.turno = turno;
    }

    public VentaCabDTO getVentaCab() {
        return ventaCab;
    }

    public void setVentaCab(VentaCabDTO ventaCab) {
        this.ventaCab = ventaCab;
    }

    public CompraCabDTO getCompraCab() {
        return compraCab;
    }

    public void setCompraCab(CompraCabDTO compraCab) {
        this.compraCab = compraCab;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

}
