package py.com.ideasweb.perseo.tesoreria.dtos;

import java.io.Serializable;

public class MonedaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codMoneda;

    private String nombre;

    private String codigo;

    private Double valorDecimal;

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
