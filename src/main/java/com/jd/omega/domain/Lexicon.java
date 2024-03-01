package com.jd.omega.domain;

import org.springframework.beans.factory.annotation.Autowired;

import com.jd.omega.dto.LexiconDTO;

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
@Table(name = "framework")
public class Lexicon extends AbstractAuditingEntity {
		
		@NotNull
		@Column(name="code", nullable=false, unique=true)
		private String code;
		
		@NotNull
		@Column(name="label", nullable=false, unique=true)
		private String label;
		
		public Lexicon(String id, long version, String code, String label) {
			super(id, version);
			this.code = code;
			this.label = label;
		}
		
		
		public Lexicon(LexiconDTO lexiconDTO) {
			this(lexiconDTO.getId(), lexiconDTO.getVersion(), lexiconDTO.getCode(), lexiconDTO.getLabel());
		}
		
		

}
