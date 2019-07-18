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
import py.com.ideasweb.perseo.comunes.entities.DepositoEntity;
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;
import py.com.ideasweb.perseo.comunes.entities.SucursalEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;
import py.com.ideasweb.perseo.tesoreria.entities.MonedaEntity;

@Entity
@Table(name = "venta_cab")
public class VentaCabEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "ventaCabSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "venta_cab_id_venta_cab_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "ventaCabSequenceGenerator")
    @Column(name = "id_venta_cab")
    private Integer idVentaCab;

    private Date fecha;

    private Timestamp fechaLog;

    private Date fechaFacturacion;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne(targetEntity = DepositoEntity.class)
    @JoinColumn(name = "id_deposito", nullable = false)
    private DepositoEntity deposito;

    @ManyToOne(targetEntity = EstadoVentaEntity.class)
    @JoinColumn(name = "id_estado_venta", nullable = false)
    private EstadoVentaEntity estadoVenta;

    @ManyToOne(targetEntity = ClienteEntity.class)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @ManyToOne(targetEntity = MonedaEntity.class)
    @JoinColumn(name = "cod_moneda")
    private MonedaEntity moneda;

    @ManyToOne(targetEntity = FormaPagoEntity.class)
    @JoinColumn(name = "id_forma_pago")
    private FormaPagoEntity formaPago;

    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursal;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

    private Double importe;

    private Double impuesto;

    private Double cantidadTotal;

    private Integer nroLoteVenta;

    private Double promedioDescuento;

    private String observacion;

    private Boolean retenido;

    private String motivoRetencion;

    @ManyToOne(targetEntity = MetodoCobroEntity.class)
    @JoinColumn(name = "id_metodo_cobro")
    private MetodoCobroEntity metodoCobro;

    @ManyToOne(targetEntity = TurnoEntity.class)
    @JoinColumn(name = "id_turno")
    private TurnoEntity turno;

    public Integer getIdVentaCab() {
        return idVentaCab;
    }

    public void setIdVentaCab(Integer idVentaCab) {
        this.idVentaCab = idVentaCab;
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

    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public DepositoEntity getDeposito() {
        return deposito;
    }

    public void setDeposito(DepositoEntity deposito) {
        this.deposito = deposito;
    }

    public EstadoVentaEntity getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVentaEntity estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public MonedaEntity getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaEntity moneda) {
        this.moneda = moneda;
    }

    public FormaPagoEntity getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPagoEntity formaPago) {
        this.formaPago = formaPago;
    }

    public SucursalEntity getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Double cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public Integer getNroLoteVenta() {
        return nroLoteVenta;
    }

    public void setNroLoteVenta(Integer nroLoteVenta) {
        this.nroLoteVenta = nroLoteVenta;
    }

    public Double getPromedioDescuento() {
        return promedioDescuento;
    }

    public void setPromedioDescuento(Double promedioDescuento) {
        this.promedioDescuento = promedioDescuento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getRetenido() {
        return retenido;
    }

    public void setRetenido(Boolean retenido) {
        this.retenido = retenido;
    }

    public String getMotivoRetencion() {
        return motivoRetencion;
    }

    public void setMotivoRetencion(String motivoRetencion) {
        this.motivoRetencion = motivoRetencion;
    }

    public MetodoCobroEntity getMetodoCobro() {
        return metodoCobro;
    }

    public void setMetodoCobro(MetodoCobroEntity metodoCobro) {
        this.metodoCobro = metodoCobro;
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
