package py.com.ideasweb.perseo.stock.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;

@Entity
@Table(name = "linea_articulo")
@JsonInclude(Include.NON_NULL)
public class LineaArticuloEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "lineaArticulosequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "unidad_medida_id_unidad_medida_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "lineaArticulosequenceGenerator")
    @Column(name = "id_linea_articulo")
    private Integer idLineaArticulo;

    private String descripcion;

    @NotNull
    @ManyToOne(targetEntity = FamiliaEntity.class)
    @JoinColumn(name = "id_familia")
    FamiliaEntity familia;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    EmpresaEntity empresa;

    public Integer getIdLineaArticulo() {
        return idLineaArticulo;
    }

    public void setIdLineaArticulo(Integer idLineaArticulo) {
        this.idLineaArticulo = idLineaArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FamiliaEntity getFamilia() {
        return familia;
    }

    public void setFamilia(FamiliaEntity familia) {
        this.familia = familia;
    }

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

}
