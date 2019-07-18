package py.com.ideasweb.perseo.stock.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import py.com.ideasweb.perseo.comunes.dtos.DepositoDTO;
import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;

public class ArticuloTransferenciaCabDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idArticuloTransferenciaCab;

    private Boolean estado;

    private Date fecha;

    private Timestamp fechaLog;

    private Integer cantidadTotal;

    private UsuarioDTO usuario;

    private DepositoDTO depositoOrigen;

    private DepositoDTO depositoDestino;

    private EmpresaDTO empresa;

    public Integer getIdArticuloTransferenciaCab() {
        return idArticuloTransferenciaCab;
    }

    public void setIdArticuloTransferenciaCab(
            Integer idArticuloTransferenciaCab) {
        this.idArticuloTransferenciaCab = idArticuloTransferenciaCab;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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

    public Integer getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public DepositoDTO getDepositoOrigen() {
        return depositoOrigen;
    }

    public void setDepositoOrigen(DepositoDTO depositoOrigen) {
        this.depositoOrigen = depositoOrigen;
    }

    public DepositoDTO getDepositoDestino() {
        return depositoDestino;
    }

    public void setDepositoDestino(DepositoDTO depositoDestino) {
        this.depositoDestino = depositoDestino;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

}
