package com.seguranca.securitysix.dtos;

import java.io.Serializable;

import com.seguranca.securitysix.models.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String authority;
	


	public RoleDTO(Role role) {
		super();
		id = role.getId();
		authority = role.getAuthority();
	}
	

}
