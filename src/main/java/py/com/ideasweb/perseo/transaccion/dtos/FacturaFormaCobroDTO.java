package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;

public class FacturaFormaCobroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idFacturaFormaCobro;

    private Double importe;

    private Boolean estado;

    private FacturaCabDTO facturaCab;

    public Integer getIdFacturaFormaCobro() {
        return idFacturaFormaCobro;
    }

    public void setIdFacturaFormaCobro(Integer idFacturaFormaCobro) {
        this.idFacturaFormaCobro = idFacturaFormaCobro;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public FacturaCabDTO getFacturaCab() {
        return facturaCab;
    }

    public void setFacturaCab(FacturaCabDTO facturaCab) {
        this.facturaCab = facturaCab;
    }

}
