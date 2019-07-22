package py.com.ideasweb.perseo.tesoreria.dtos;

import java.io.Serializable;

public class OrdenPagoFpDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idOrdenPagoFp;

    private Double importe;

    private Double cotizacion;

    private String transaccion;

    private OrdenPagoCabDTO ordenPagoCab;

    private CajaCuentaDTO cajaCuenta;

    public Integer getIdOrdenPagoFp() {
        return idOrdenPagoFp;
    }

    public void setIdOrdenPagoFp(Integer idOrdenPagoFp) {
        this.idOrdenPagoFp = idOrdenPagoFp;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public OrdenPagoCabDTO getOrdenPagoCab() {
        return ordenPagoCab;
    }

    public void setOrdenPagoCab(OrdenPagoCabDTO ordenPagoCab) {
        this.ordenPagoCab = ordenPagoCab;
    }

    public CajaCuentaDTO getCajaCuenta() {
        return cajaCuenta;
    }

    public void setCajaCuenta(CajaCuentaDTO cajaCuenta) {
        this.cajaCuenta = cajaCuenta;
    }

}
