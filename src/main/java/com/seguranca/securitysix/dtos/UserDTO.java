package com.seguranca.securitysix.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.seguranca.securitysix.models.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String firstName;
	private String lastName;

	@Email(message = "Favor entrar um email válido")
	private String email;
	
	Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO(User entity) {
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		email = entity.getEmail();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}
}
