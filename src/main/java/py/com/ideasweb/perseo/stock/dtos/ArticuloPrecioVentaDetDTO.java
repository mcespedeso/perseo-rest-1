package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;

public class ArticuloPrecioVentaDetDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idArticuloPrecioVentaDet;

    private ArticuloPrecioVentaCabDTO articuloPrecioVentaCab;

    private ArticuloDTO articulo;

    private Double precio;

    public Integer getIdArticuloPrecioVentaDet() {
        return idArticuloPrecioVentaDet;
    }

    public void setIdArticuloPrecioVentaDet(Integer idArticuloPrecioVentaDet) {
        this.idArticuloPrecioVentaDet = idArticuloPrecioVentaDet;
    }

    public ArticuloPrecioVentaCabDTO getArticuloPrecioVentaCab() {
        return articuloPrecioVentaCab;
    }

    public void setArticuloPrecioVentaCab(
            ArticuloPrecioVentaCabDTO articuloPrecioVentaCab) {
        this.articuloPrecioVentaCab = articuloPrecioVentaCab;
    }

    public ArticuloDTO getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloDTO articulo) {
        this.articulo = articulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
