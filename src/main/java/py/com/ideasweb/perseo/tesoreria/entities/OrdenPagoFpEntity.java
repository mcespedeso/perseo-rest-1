package py.com.ideasweb.perseo.tesoreria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import py.com.ideasweb.perseo.common.entities.BaseEntity;

@Entity
@Table(name = "orden_pago_fp")
public class OrdenPagoFpEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "ordenPagoFpSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "orden_pago_fp_id_orden_pago_fp_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "ordenPagoFpSequenceGenerator")
    @Column(name = "id_orden_pago_fp")
    private Integer idOrdenPagoFp;

    private Double importe;

    private Double cotizacion;

    private String transaccion;

    @ManyToOne(targetEntity = OrdenPagoCabEntity.class)
    @JoinColumn(name = "id_orden_pago_cab")
    private OrdenPagoCabEntity ordenPagoCab;

    @ManyToOne(targetEntity = CajaCuentaEntity.class)
    @JoinColumn(name = "id_caja_cuenta")
    private CajaCuentaEntity cajaCuenta;

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

    public OrdenPagoCabEntity getOrdenPagoCab() {
        return ordenPagoCab;
    }

    public void setOrdenPagoCab(OrdenPagoCabEntity ordenPagoCab) {
        this.ordenPagoCab = ordenPagoCab;
    }

    public CajaCuentaEntity getCajaCuenta() {
        return cajaCuenta;
    }

    public void setCajaCuenta(CajaCuentaEntity cajaCuenta) {
        this.cajaCuenta = cajaCuenta;
    }

}