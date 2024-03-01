package com.jd.omega.dto;

import java.time.Instant;

import com.jd.omega.domain.AbstractAuditingEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractAuditingDTO extends AbstractDomainDTO {
	protected String createdBy;
	protected String lastModifiedBy;
	protected Instant createdDate;
	protected Instant lastModifiedDate;
	
	public AbstractAuditingDTO(
			String id,
			long version,
			String createdBy,
			String lastModifiedBy,
			Instant createdDate,
			Instant lastModifiedDate) {
		super(id, version);
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public AbstractAuditingDTO(AbstractAuditingEntity auditingEntity) {
		this(
				auditingEntity.getId(),
				auditingEntity.getVersion(),
				auditingEntity.getCreatedBy(),
				auditingEntity.getLastModifiedBy(),
				auditingEntity.getCreatedDate(),
				auditingEntity.getLastModifiedDate());		
	}
	
	public AbstractAuditingDTO(String id, long version) { super(id, version); }

}
