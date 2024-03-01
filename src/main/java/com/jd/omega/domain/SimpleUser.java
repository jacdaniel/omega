package com.jd.omega.domain;

import com.jd.omega.dto.LexiconDTO;
import com.jd.omega.dto.SimpleUserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "simple_user")
public class SimpleUser extends AbstractAuditingEntity {
	@NotNull
	@Column(name="first_name", nullable=false, unique=true)
	private String firstName;
	
	@NotNull
	@Column(name="name", nullable=false, unique=true)
	private String name;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;

	
	public SimpleUser(String id, long version, String firstName, String name, String email) {
		super(id, version);
		this.firstName = firstName;
		this.name = name;
		this.email = email;
	}
	
	
	public SimpleUser(SimpleUserDTO simpleUserDTO) {
		this(simpleUserDTO.getId(), simpleUserDTO.getVersion(), simpleUserDTO.getFirstName(), simpleUserDTO.getFirstName(), simpleUserDTO.getEmail());
	}
}
