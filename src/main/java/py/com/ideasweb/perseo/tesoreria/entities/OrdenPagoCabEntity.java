package py.com.ideasweb.perseo.tesoreria.entities;

import java.sql.Date;

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
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;
import py.com.ideasweb.perseo.comunes.entities.SucursalEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;

@Entity
@Table(name = "orden_pago_cab")
public class OrdenPagoCabEntity extends BaseEntity{

    public static final String PENDIENTE = "PE";
    public static final String PAGADO = "PA";

    @Id
    @GenericGenerator(name = "ordenPagoCabSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "orden_pago_cab_id_orden_pago_cab_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "ordenPagoCabSequenceGenerator")
    @Column(name = "id_orden_pago_cab")
    private Integer idOrdenPagoCab;

    private Date fecha;

    private String beneficiario;

    private String concepto;

    private String comentario;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne(targetEntity = MonedaEntity.class)
    @JoinColumn(name = "cod_moneda")
    private MonedaEntity moneda;

    private Double importe;

    private Double cotizacion;

    private String estado;

    private Date fechaPago;

    private Boolean retenido;

    private Double importeRetenido;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursal;

    public Integer getIdOrdenPagoCab() {
        return idOrdenPagoCab;
    }

    public void setIdOrdenPagoCab(Integer idOrdenPagoCab) {
        this.idOrdenPagoCab = idOrdenPagoCab;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public MonedaEntity getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaEntity moneda) {
        this.moneda = moneda;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Boolean getRetenido() {
        return retenido;
    }

    public void setRetenido(Boolean retenido) {
        this.retenido = retenido;
    }

    public Double getImporteRetenido() {
        return importeRetenido;
    }

    public void setImporteRetenido(Double importeRetenido) {
        this.importeRetenido = importeRetenido;
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

}