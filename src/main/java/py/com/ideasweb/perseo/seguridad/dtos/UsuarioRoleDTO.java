package py.com.ideasweb.perseo.seguridad.dtos;

import com.google.common.base.MoreObjects;

public class UsuarioRoleDTO {

	private Long userRoleId;

	private String login;

	private String role;
	
	public UsuarioRoleDTO(){}
	
	private UsuarioRoleDTO(Long userRoleId, String login, String role) {
		this.userRoleId = userRoleId;
		this.login = login;
		this.role = role;
	}
	
	public static class Builder {
		private Long userRoleId;
		private String login;
		private String role;
		
		public Builder userRoleId(Long userRoleId) {
			this.userRoleId = userRoleId;
			return this;
		}
		
		public Builder user(String login) {
			this.login = login;
			return this;
		}
		
		public Builder role(String role) {
			this.role = role;
			return this;
		}
		
		public UsuarioRoleDTO build() {
			return new UsuarioRoleDTO(userRoleId, login, role);
		}
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("userRoleId", userRoleId)
				.add("login", login)
				.add("role", role)
				.toString();
	}

}
