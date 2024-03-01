package com.jd.omega.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class AbstractDomainObject implements Serializable {
	
	@Version private long version;
	
	@Id
	@NotNull
	@Column(updatable = false)
	private String id;
	
	public AbstractDomainObject(String id, long version) {
		this.id = id;
		this.version = version;
	}
	
	@PrePersist
	public void initializeUUID() {
		if ( id == null ) {
			id = UUID.randomUUID().toString();
			}
		}
	
	@Override
	public boolean equals(final Object obj) {
		if ( id == null) {
			return obj == null;
		}
		if ( obj == this ) {
			return true;
		}
		if ( obj == null) {
			return false;
		}
		if ( this.getClass().isInstance(obj)) {
			final AbstractDomainObject other = (AbstractDomainObject) obj;
			return Objects.equals(getId(), other.getId());
		}
		return false;
	}
	
	@Override
	public String toString() { return this.getClass().getName() + " [id=" + id + "]";} 

}
