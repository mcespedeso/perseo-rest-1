package py.com.ideasweb.perseo.stock.entities;

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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;
import py.com.ideasweb.perseo.comunes.entities.TipoImpuestoEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;
import py.com.ideasweb.perseo.tesoreria.entities.MonedaEntity;

@Entity
@Table(name = "articulo")
@JsonInclude(Include.NON_NULL)
public class ArticuloEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "articuloSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "articulo_id_articulo_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "articuloSequenceGenerator")
    @Column(name = "id_articulo")
    private Integer idArticulo;

    private String descripcion;

    private String codigoBarra;

    @ManyToOne(targetEntity = FamiliaEntity.class)
    @JoinColumn(name = "id_familia")
    private FamiliaEntity familia;

    @ManyToOne(targetEntity = MarcaEntity.class)
    @JoinColumn(name = "id_marca")
    private MarcaEntity marca;

    @ManyToOne(targetEntity = MonedaEntity.class)
    @JoinColumn(name = "id_moneda")
    private MonedaEntity moneda;

    private Boolean estado;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    EmpresaEntity empresa;

    @ManyToOne(targetEntity = UnidadMedidaEntity.class)
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedidaEntity unidadMedida;

    @ManyToOne(targetEntity = TipoImpuestoEntity.class)
    @JoinColumn(name = "id_tipo_impuesto")
    private TipoImpuestoEntity tipoImpuesto;

    @ManyToOne(targetEntity = LineaArticuloEntity.class)
    @JoinColumn(name = "id_linea_articulo")
    private LineaArticuloEntity lineaArticulo;

    private Timestamp fechaLog;

    private Date fechaEstado;

    public ArticuloEntity() {
        super();
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public FamiliaEntity getFamilia() {
        return familia;
    }

    public void setFamilia(FamiliaEntity familia) {
        this.familia = familia;
    }

    public MarcaEntity getMarca() {
        return marca;
    }

    public void setMarca(MarcaEntity marca) {
        this.marca = marca;
    }

    public MonedaEntity getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaEntity moneda) {
        this.moneda = moneda;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

    public UnidadMedidaEntity getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedidaEntity unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public TipoImpuestoEntity getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuestoEntity tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public LineaArticuloEntity getLineaArticulo() {
        return lineaArticulo;
    }

    public void setLineaArticulo(LineaArticuloEntity lineaArticulo) {
        this.lineaArticulo = lineaArticulo;
    }

    public Timestamp getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    @PrePersist
    public void preSave() {
        this.fechaLog = new Timestamp(System.currentTimeMillis());
    }
}
