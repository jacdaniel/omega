package com.jd.omega.domain;

import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jd.omega.utils.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class AbstractAuditingEntity extends AbstractDomainObject {
	
	@CreatedBy
	@Column(
			name = "created_by",
			updatable = false,
			nullable = false,
			columnDefinition = "varchar(5000) default " + Constants.SYSTEM_ACCOUNT )
	@JsonIgnore
	private String createdBy = Constants.SYSTEM_ACCOUNT;
	
	@LastModifiedBy
	@Column(
			name = "last_modified_by",
			updatable = false,
			nullable = false,
			columnDefinition = "timestamp default now()"
			)
	@JsonIgnore
	private String lastModifiedBy = Constants.SYSTEM_ACCOUNT;
	
	@CreatedDate
	@Column(
			name = "created_date",
			updatable = false,
			nullable = false,
			columnDefinition = "timestamp default now()")
	@JsonIgnore
	private Instant createdDate = Instant.now();
	
	@LastModifiedDate
	@Column(
			name = "last_modified_date",
			updatable = false,
			nullable = false,
			columnDefinition = "timestamp default now()")
	@JsonIgnore
	private Instant lastModifiedDate = Instant.now();
	
	public AbstractAuditingEntity(
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
	
	public AbstractAuditingEntity(String id, long version) { super(id, version); }
	
	
	
	
	
	
	
	
	


}
