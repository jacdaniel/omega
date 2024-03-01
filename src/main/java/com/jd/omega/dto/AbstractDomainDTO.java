package com.jd.omega.dto;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractDomainDTO implements Serializable {
	
	protected String id;
	protected long version;
	
	public AbstractDomainDTO(String id, long version) {
		this.id = id;
		this.version = version;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if ( getId() == null ) {
			return obj == null;
		}
		if ( obj == this ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( this.getClass().isInstance(obj)) {
			final AbstractDomainDTO other = (AbstractDomainDTO) obj;
			return Objects.equals(getId(),  other.getId());
		}
		return false;
	}
	

}
