package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;

public class ArticuloTransferenciaDetDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idArticuloTransferenciaDet;

    private Integer cantidadContado;

    private Integer cantidadRecibido;

    private ArticuloTransferenciaCabDTO articuloTransferenciaCab;

    private ArticuloDTO articulo;

    public Integer getIdArticuloTransferenciaDet() {
        return idArticuloTransferenciaDet;
    }

    public void setIdArticuloTransferenciaDet(
            Integer idArticuloTransferenciaDet) {
        this.idArticuloTransferenciaDet = idArticuloTransferenciaDet;
    }

    public Integer getCantidadContado() {
        return cantidadContado;
    }

    public void setCantidadContado(Integer cantidadContado) {
        this.cantidadContado = cantidadContado;
    }

    public Integer getCantidadRecibido() {
        return cantidadRecibido;
    }

    public void setCantidadRecibido(Integer cantidadRecibido) {
        this.cantidadRecibido = cantidadRecibido;
    }

    public ArticuloTransferenciaCabDTO getArticuloTransferenciaCab() {
        return articuloTransferenciaCab;
    }

    public void setArticuloTransferenciaCab(
            ArticuloTransferenciaCabDTO articuloTransferenciaCab) {
        this.articuloTransferenciaCab = articuloTransferenciaCab;
    }

    public ArticuloDTO getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloDTO articulo) {
        this.articulo = articulo;
    }

}
