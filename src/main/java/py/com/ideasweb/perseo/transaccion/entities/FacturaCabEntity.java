package py.com.ideasweb.perseo.transaccion.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.comunes.entities.ClienteEntity;
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;
import py.com.ideasweb.perseo.comunes.entities.SucursalEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;
import py.com.ideasweb.perseo.tesoreria.entities.CajaEntity;
import py.com.ideasweb.perseo.tesoreria.entities.MonedaEntity;

@Entity
@Table(name = "factura_cab")
public class FacturaCabEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "facturaCabSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "factura_cab_id_factura_cab_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "facturaCabSequenceGenerator")
    @Column(name = "id_factura_cab")
    private Integer idFacturaCab;

    private Date fecha;

    private Timestamp fechaLog;

    @ManyToOne(targetEntity = ClienteEntity.class)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    private Boolean estado;

    @ManyToOne(targetEntity = MonedaEntity.class)
    @JoinColumn(name = "cod_moneda")
    private MonedaEntity moneda;

    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursal;

    private Integer establecimiento;

    private Integer puntoExpedicion;

    private Integer nroFactura;

    private Double importe;

    private Double saldo;

    private String observacion;

    private Boolean impreso;

    @ManyToOne(targetEntity = MetodoCobroEntity.class)
    @JoinColumn(name = "id_metodo_cobro")
    private MetodoCobroEntity metodoCobro;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

    @ManyToOne(targetEntity = TipoFacturaEntity.class)
    @JoinColumn(name = "id_tipo_factura")
    TipoFacturaEntity tipoFactura;

    private Double cotizacion;

    @ManyToOne(targetEntity = CajaEntity.class)
    @JoinColumn(name = "id_caja")
    private CajaEntity caja;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    private Timestamp fechaAnulacion;

    @ManyToOne(targetEntity = VentaCabEntity.class)
    @JoinColumn(name = "id_venta_cab")
    private VentaCabEntity ventaCab;

    private Integer timbrado;

    private Date vigencia_Timbrado;

    @ManyToOne(targetEntity = TurnoEntity.class)
    @JoinColumn(name = "id_turno")
    private TurnoEntity turno;

    public Integer getIdFacturaCab() {
        return idFacturaCab;
    }

    public void setIdFacturaCab(Integer idFacturaCab) {
        this.idFacturaCab = idFacturaCab;
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

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public MonedaEntity getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaEntity moneda) {
        this.moneda = moneda;
    }

    public SucursalEntity getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Integer establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Integer getPuntoExpedicion() {
        return puntoExpedicion;
    }

    public void setPuntoExpedicion(Integer puntoExpedicion) {
        this.puntoExpedicion = puntoExpedicion;
    }

    public Integer getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(Integer nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getImpreso() {
        return impreso;
    }

    public void setImpreso(Boolean impreso) {
        this.impreso = impreso;
    }

    public MetodoCobroEntity getMetodoCobro() {
        return metodoCobro;
    }

    public void setMetodoCobro(MetodoCobroEntity metodoCobro) {
        this.metodoCobro = metodoCobro;
    }

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

    public TipoFacturaEntity getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(TipoFacturaEntity tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Double getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public CajaEntity getCaja() {
        return caja;
    }

    public void setCaja(CajaEntity caja) {
        this.caja = caja;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public Timestamp getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Timestamp fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public VentaCabEntity getVentaCab() {
        return ventaCab;
    }

    public void setVentaCab(VentaCabEntity ventaCab) {
        this.ventaCab = ventaCab;
    }

    public Integer getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(Integer timbrado) {
        this.timbrado = timbrado;
    }

    public Date getVigencia_Timbrado() {
        return vigencia_Timbrado;
    }

    public void setVigencia_Timbrado(Date vigencia_Timbrado) {
        this.vigencia_Timbrado = vigencia_Timbrado;
    }

    public TurnoEntity getTurno() {
        return turno;
    }

    public void setTurno(TurnoEntity turno) {
        this.turno = turno;
    }

    @PrePersist
    public void preSave() {
        this.fechaLog = new Timestamp(System.currentTimeMillis());
    }

}
