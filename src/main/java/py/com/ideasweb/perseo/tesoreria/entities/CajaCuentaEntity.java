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
@Table(name = "caja_cuenta")
public class CajaCuentaEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "cajaCuentaSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "caja_cuenta_id_caja_cuenta_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "cajaCuentaSequenceGenerator")
    @Column(name = "id_caja_cuenta")
    private Integer idCajaCuenta;

    private Integer numero;

    private String descripcion;

    private Boolean estado;

    private String tipo;

    private String cuentabanco;

    @ManyToOne(targetEntity = CajaEntity.class)
    @JoinColumn(name = "id_caja")
    private CajaEntity caja;

    @ManyToOne(targetEntity = MonedaEntity.class)
    @JoinColumn(name = "cod_moneda")
    private MonedaEntity moneda;

    @ManyToOne(targetEntity = BancoEntity.class)
    @JoinColumn(name = "id_banco")
    private BancoEntity banco;

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

    public CajaEntity getCaja() {
        return caja;
    }

    public void setCaja(CajaEntity caja) {
        this.caja = caja;
    }

    public MonedaEntity getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaEntity moneda) {
        this.moneda = moneda;
    }

    public BancoEntity getBanco() {
        return banco;
    }

    public void setBanco(BancoEntity banco) {
        this.banco = banco;
    }

}
