package py.com.ideasweb.perseo.tesoreria.dtos;

import java.io.Serializable;

public class CajaCuentaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCajaCuenta;

    private Integer numero;

    private String descripcion;

    private Boolean estado;

    private String tipo;

    private String cuentabanco;

    private CajaDTO caja;

    private MonedaDTO moneda;

    private BancoDTO banco;

    public Integer getIdCajaCuenta() {
        return idCajaCuenta;
    }

    public void setIdCajaCuenta(Integer idCajaCuenta) {
        this.idCajaCuenta = idCajaCuenta;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCuentabanco() {
        return cuentabanco;
    }

    public void setCuentabanco(String cuentabanco) {
        this.cuentabanco = cuentabanco;
    }

    public CajaDTO getCaja() {
        return caja;
    }

    public void setCaja(CajaDTO caja) {
        this.caja = caja;
    }

    public MonedaDTO getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaDTO moneda) {
        this.moneda = moneda;
    }

    public BancoDTO getBanco() {
        return banco;
    }

    public void setBanco(BancoDTO banco) {
        this.banco = banco;
    }

}
