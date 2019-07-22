package py.com.ideasweb.perseo.tesoreria.dtos;

import java.io.Serializable;

public class OrdenPagoDetDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idOrdenPagoDet;

    private Double importe;

    private String concepto;

    private OrdenPagoCabDTO ordenpagocab;

    public Integer getIdOrdenPagoDet() {
        return idOrdenPagoDet;
    }

    public void setIdOrdenPagoDet(Integer idOrdenPagoDet) {
        this.idOrdenPagoDet = idOrdenPagoDet;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public OrdenPagoCabDTO getOrdenpagocab() {
        return ordenpagocab;
    }

    public void setOrdenpagocab(OrdenPagoCabDTO ordenpagocab) {
        this.ordenpagocab = ordenpagocab;
    }
    
    

}
