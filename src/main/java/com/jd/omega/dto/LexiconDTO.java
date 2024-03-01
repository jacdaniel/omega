package com.jd.omega.dto;

import com.jd.omega.domain.Lexicon;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
// @NoArgsConstructor
// @AllArgsConstructor
public class LexiconDTO extends AbstractAuditingDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	private String code;
	
	
	public LexiconDTO(String id, long version, String label) {
		super(id, version);
		this.label = label;
	}
	
	public LexiconDTO(Lexicon lexicon) {
		super(lexicon);
		label = lexicon.getLabel();
		code = lexicon.getCode();
	}
	
	public Lexicon toLexicon() {
		Lexicon lexicon = new Lexicon(id, version, code, label);
		return lexicon;
	}
}



	

