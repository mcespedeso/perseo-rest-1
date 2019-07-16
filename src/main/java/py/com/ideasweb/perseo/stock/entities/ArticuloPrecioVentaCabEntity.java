package py.com.ideasweb.perseo.stock.entities;

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

import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;

@Entity
@Table(name = "articulo_precio_venta_cab")
public class ArticuloPrecioVentaCabEntity {

    @Id
    @GenericGenerator(name = "articuloPrecioVentaCabSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "articulo_precio_venta_cab_id_articulo_precio_venta_cab_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "articuloPrecioVentaCabSequenceGenerator")

    @Column(name = "id_articulo_precio_venta_cab")
    private Integer idArticuloPrecioVentaCab;

    private String descripcion;

    private Boolean estado;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    EmpresaEntity empresa;

    public Integer getIdArticuloPrecioVentaCab() {
        return idArticuloPrecioVentaCab;
    }

    public void setIdArticuloPrecioVentaCab(Integer idArticuloPrecioVentaCab) {
        this.idArticuloPrecioVentaCab = idArticuloPrecioVentaCab;
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

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

}
