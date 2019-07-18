package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;

public class HistoricoPrecioCostoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idHistoricoPrecioCosto;

    private Date fecha;

    private Timestamp fechaLog;

    private String concepto;

    private Double precioCosto;

    private UsuarioDTO usuario;

    private EmpresaDTO empresa;

    private ArticuloDTO articulo;

    public Integer getIdHistoricoPrecioCosto() {
        return idHistoricoPrecioCosto;
    }

    public void setIdHistoricoPrecioCosto(Integer idHistoricoPrecioCosto) {
        this.idHistoricoPrecioCosto = idHistoricoPrecioCosto;
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

    public ArticuloDTO getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloDTO articulo) {
        this.articulo = articulo;
    }

}
