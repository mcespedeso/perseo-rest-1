package py.com.ideasweb.perseo.seguridad.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import py.com.ideasweb.perseo.common.entities.BaseEntity;

@Entity
@Table(name = "roles")
public class RolesEntity extends BaseEntity {

	@Id
	@GenericGenerator(name = "rolesSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "roles_id_seq"),
			@Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
			@Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
	@GeneratedValue(generator = "rolesSequenceGenerator")
	@Column(name = "id_role")
	private Integer idRole;

	@NotNull
	@Column(name = "role")
	private String role;

	public RolesEntity() {
		super();
	}

	public RolesEntity(Integer idRole, @NotNull String role) {
		super();
		this.idRole = idRole;
		this.role = role;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
