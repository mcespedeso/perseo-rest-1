package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;

import py.com.ideasweb.perseo.comunes.dtos.DepositoDTO;
import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;
import py.com.ideasweb.perseo.transaccion.dtos.TurnoDTO;

public class HistoricoArticuloDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idHistoricoArticulo;

    private TurnoDTO turno;

    private SucursalDTO sucursal;

    private ArticuloDepositoDTO articuloDeposito;

    private DepositoDTO deposito;

    private EmpresaDTO empresa;

    private Double anterior;

    private Double entrada;

    private Double venta;

    private Double actual;

    private Double precioCosto;

    private Double precioVenta;

    public Integer getIdHistoricoArticulo() {
        return idHistoricoArticulo;
    }

    public void setIdHistoricoArticulo(Integer idHistoricoArticulo) {
        this.idHistoricoArticulo = idHistoricoArticulo;
    }

    public TurnoDTO getTurno() {
        return turno;
    }

    public void setTurno(TurnoDTO turno) {
        this.turno = turno;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    public ArticuloDepositoDTO getArticuloDeposito() {
        return articuloDeposito;
    }

    public void setArticuloDeposito(ArticuloDepositoDTO articuloDeposito) {
        this.articuloDeposito = articuloDeposito;
    }

    public DepositoDTO getDeposito() {
        return deposito;
    }

    public void setDeposito(DepositoDTO deposito) {
        this.deposito = deposito;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public Double getAnterior() {
        return anterior;
    }

    public void setAnterior(Double anterior) {
        this.anterior = anterior;
    }

    public Double getEntrada() {
        return entrada;
    }

    public void setEntrada(Double entrada) {
        this.entrada = entrada;
    }

    public Double getVenta() {
        return venta;
    }

    public void setVenta(Double venta) {
        this.venta = venta;
    }

    public Double getActual() {
        return actual;
    }

    public void setActual(Double actual) {
        this.actual = actual;
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

}
