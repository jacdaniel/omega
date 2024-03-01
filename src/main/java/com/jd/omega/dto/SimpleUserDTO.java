package com.jd.omega.dto;

import com.jd.omega.domain.SimpleUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleUserDTO extends AbstractAuditingDTO {
	
	private String firstName;
	private String name;
	private String email;
	
	public SimpleUserDTO(SimpleUser simpleUser) {
		super(simpleUser);
		firstName = simpleUser.getFirstName();
		name = simpleUser.getName();
		email = simpleUser.getEmail();		
	}
	
	// important
	// c'est ce qui est appelé dans la resource
	public SimpleUserDTO(String id, long version, String firstName, String name, String email) {
		super(id, version);
		this.firstName = firstName;
		this.name = name;
		this.email = email;
	}
	
	public SimpleUser toSimpleUser() {
		return new SimpleUser(id, version, firstName, name, email);
	}

}
