package py.com.ideasweb.perseo.transaccion.dtos;

import java.io.Serializable;
import java.sql.Date;

public class FacturaPlazoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idFacturaPlazo;

    private FacturaCabDTO facturaCab;

    private Date fechaVencimiento;

    public Integer getIdFacturaPlazo() {
        return idFacturaPlazo;
    }

    public void setIdFacturaPlazo(Integer idFacturaPlazo) {
        this.idFacturaPlazo = idFacturaPlazo;
    }

    public FacturaCabDTO getFacturaCab() {
        return facturaCab;
    }

    public void setFacturaCab(FacturaCabDTO facturaCab) {
        this.facturaCab = facturaCab;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
