package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;
import java.sql.Date;

import py.com.ideasweb.perseo.app.articulo.model.ArticuloLite;
import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.comunes.dtos.TipoImpuestoDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.tesoreria.dtos.MonedaDTO;

public class ArticuloDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idArticulo;

    private String descripcion;

    private String codigoBarra;

    private FamiliaDTO familia;

    private MarcaDTO marca;

    private MonedaDTO moneda;

    private Boolean estado;

    private UsuarioDTO usuario;

    private EmpresaDTO empresa;

    private UnidadMedidaDTO unidadMedida;

    private TipoImpuestoDTO tipoImpuesto;

    private LineaArticuloDTO lineaArticulo;

    private Date fechaEstado;

    public ArticuloDTO() {
        super();
    }

  

    public ArticuloDTO(ArticuloLite lite) {
        super();
        this.idArticulo = lite.getIdArticulo();
        this.descripcion = lite.getDescripcion();
        this.codigoBarra = lite.getCodigoBarra();
        this.estado = lite.getEstado();
        this.empresa = new EmpresaDTO(lite.getIdEmpresa());;
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

    public FamiliaDTO getFamilia() {
        return familia;
    }

    public void setFamilia(FamiliaDTO familia) {
        this.familia = familia;
    }

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }

    public MonedaDTO getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaDTO moneda) {
        this.moneda = moneda;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public UnidadMedidaDTO getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedidaDTO unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public TipoImpuestoDTO getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuestoDTO tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public LineaArticuloDTO getLineaArticulo() {
        return lineaArticulo;
    }

    public void setLineaArticulo(LineaArticuloDTO lineaArticulo) {
        this.lineaArticulo = lineaArticulo;
    }

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

}
