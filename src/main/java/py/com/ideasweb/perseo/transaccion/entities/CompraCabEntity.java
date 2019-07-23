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
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;
import py.com.ideasweb.perseo.comunes.entities.ProveedorEntity;
import py.com.ideasweb.perseo.comunes.entities.SucursalEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;
import py.com.ideasweb.perseo.tesoreria.entities.MonedaEntity;

@Entity
@Table(name = "estado_compra")
public class CompraCabEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "compraCabSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "compra_cab_id_compra_cab_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "compraCabSequenceGenerator")
    @Column(name = "id_compra_cab")
    private Integer idCompraCab;

    private Date fecha;

    private Timestamp fechaLog;

    private String tipo;

    private String comprobante;

    @ManyToOne(targetEntity = ProveedorEntity.class)
    @JoinColumn(name = "id_proveedor")
    private ProveedorEntity proveedor;

    @ManyToOne(targetEntity = MonedaEntity.class)
    @JoinColumn(name = "cod_moneda")
    private MonedaEntity moneda;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursal;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    private Double importe;

    private Double pagado;

    @ManyToOne(targetEntity = EstadoCompraEntity.class)
    @JoinColumn(name = "id_estado_compra")
    private EstadoCompraEntity estadoCompra;

    private Double gravada10;

    private Double gravada5;

    private Double iva10;

    private Double iva5;

    private Double exenta;

    private String condicion;

    private String timbrado;

    private Date fecVencTimbrado;

    private Double cotizacion;

    private Integer cantidadCuota;

    private String observaciones;

    @ManyToOne(targetEntity = TurnoEntity.class)
    @JoinColumn(name = "id_turno")
    private TurnoEntity turno;

    public Integer getIdCompraCab() {
        return idCompraCab;
    }

    public void setIdCompraCab(Integer idCompraCab) {
        this.idCompraCab = idCompraCab;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public MonedaEntity getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaEntity moneda) {
        this.moneda = moneda;
    }

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

    public SucursalEntity getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getPagado() {
        return pagado;
    }

    public void setPagado(Double pagado) {
        this.pagado = pagado;
    }

    public EstadoCompraEntity getEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(EstadoCompraEntity estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    public Double getGravada10() {
        return gravada10;
    }

    public void setGravada10(Double gravada10) {
        this.gravada10 = gravada10;
    }

    public Double getGravada5() {
        return gravada5;
    }

    public void setGravada5(Double gravada5) {
        this.gravada5 = gravada5;
    }

    public Double getIva10() {
        return iva10;
    }

    public void setIva10(Double iva10) {
        this.iva10 = iva10;
    }

    public Double getIva5() {
        return iva5;
    }

    public void setIva5(Double iva5) {
        this.iva5 = iva5;
    }

    public Double getExenta() {
        return exenta;
    }

    public void setExenta(Double exenta) {
        this.exenta = exenta;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
    }

    public Date getFecVencTimbrado() {
        return fecVencTimbrado;
    }

    public void setFecVencTimbrado(Date fecVencTimbrado) {
        this.fecVencTimbrado = fecVencTimbrado;
    }

    public Double getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Integer getCantidadCuota() {
        return cantidadCuota;
    }

    public void setCantidadCuota(Integer cantidadCuota) {
        this.cantidadCuota = cantidadCuota;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
