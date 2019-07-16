package py.com.ideasweb.perseo.tesoreria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import py.com.ideasweb.perseo.common.entities.BaseEntity;

@Entity
@Table(name = "moneda")
@JsonInclude(Include.NON_NULL)
public class MonedaEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "monedaSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "moneda_cod_moneda_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "monedaSequenceGenerator")
    @Column(name = "cod_moneda")
    private Integer codMoneda;

    private String nombre;

    private String codigo;

    private Double valorDecimal;

    public MonedaEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(Integer codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getValorDecimal() {
        return valorDecimal;
    }

    public void setValorDecimal(Double valorDecimal) {
        this.valorDecimal = valorDecimal;
    }

}
