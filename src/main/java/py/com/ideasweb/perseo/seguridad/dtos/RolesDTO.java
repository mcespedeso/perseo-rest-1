package py.com.ideasweb.perseo.seguridad.dtos;

import java.io.Serializable;

public class RolesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idRole;

	private String role;

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
