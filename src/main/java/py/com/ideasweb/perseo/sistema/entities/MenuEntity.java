package py.com.ideasweb.perseo.sistema.entities;

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

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.seguridad.entities.PerfilEntity;

@Entity
@Table(name = "menu")
public class MenuEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "menuSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "menu_id_menu_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "menuSequenceGenerator")
    @Column(name = "id_menu")
    private Integer idMenu;

    private String descripcion;

    private Boolean estado;

    private String tipo;

    private String mnemonic;

    @ManyToOne(targetEntity = PerfilEntity.class)
    @JoinColumn(name = "id_perfil")
    private PerfilEntity perfil;

    @ManyToOne(targetEntity = ClaseEntity.class)
    @JoinColumn(name = "id_clase")
    private ClaseEntity clase;

    @ManyToOne(targetEntity = MenuEntity.class)
    @JoinColumn(name = "menu_anterior")
    private MenuEntity menuAnterior;

    private Integer orden;

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public ClaseEntity getClase() {
        return clase;
    }

    public void setClase(ClaseEntity clase) {
        this.clase = clase;
    }

    public MenuEntity getMenuAnterior() {
        return menuAnterior;
    }

    public void setMenuAnterior(MenuEntity menuAnterior) {
        this.menuAnterior = menuAnterior;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

}
