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

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;

@Entity
@Table(name = "historico_precio_venta")
public class HistoricoPrecioVentaEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "HistoricoPrecioVentaSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "historico_precio_venta_id_historico_precio_venta_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "HistoricoPrecioVentaSequenceGenerator")
    @Column(name = "id_historico_precio_venta")
    private Integer idHistoricoPrecioVenta;

    private Date fecha;

    private Timestamp fechaLog;

    private String concepto;

    private Double precioCosto;

    private Double precioVenta;

    private Double porcentaje;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

    @ManyToOne(targetEntity = ArticuloPrecioVentaDetEntity.class)
    @JoinColumn(name = "id_articulo_precio_venta_det", nullable = false)
    private ArticuloPrecioVentaDetEntity articuloPrecioVentaDet;

    public Integer getIdHistoricoPrecioVenta() {
        return idHistoricoPrecioVenta;
    }

    public void setIdHistoricoPrecioVenta(Integer idHistoricoPrecioVenta) {
        this.idHistoricoPrecioVenta = idHistoricoPrecioVenta;
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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
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

    public ArticuloPrecioVentaDetEntity getArticuloPrecioVentaDet() {
        return articuloPrecioVentaDet;
    }

    public void setArticuloPrecioVentaDet(
            ArticuloPrecioVentaDetEntity articuloPrecioVentaDet) {
        this.articuloPrecioVentaDet = articuloPrecioVentaDet;
    }

    @PrePersist
    public void preSave() {
        this.fechaLog = new Timestamp(System.currentTimeMillis());
    }

}
