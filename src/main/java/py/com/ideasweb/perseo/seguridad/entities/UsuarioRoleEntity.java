package py.com.ideasweb.perseo.seguridad.entities;

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

@Entity
@Table(name = "usuario_x_role")
public class UsuarioRoleEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "usuarioRolesSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SCHEMA, value = "seguridad"),
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "usuario_x_role_id_usuario_x_role_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "usuarioRolesSequenceGenerator")
    @Column(name = "id_usuario_x_role")
    private Long id;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne(targetEntity = RolesEntity.class)
    @JoinColumn(name = "id_role")
    private RolesEntity roles;

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolesEntity getRoles() {
        return roles;
    }

    public void setRoles(RolesEntity roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UsuarioRoleEntity [id=" + id + ", user=" + usuario + ", role="
                + roles + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (id == null || obj == null || getClass() != obj.getClass())
            return false;
        UsuarioRoleEntity toCompare = (UsuarioRoleEntity) obj;
        return id.equals(toCompare.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

}
