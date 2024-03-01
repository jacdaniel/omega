package com.jd.omega.service.lexicon;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jd.omega.domain.Lexicon;
import com.jd.omega.dto.LexiconDTO;
import com.jd.omega.repository.lexicon.LexiconRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class LexiconService {
	
	public final LexiconRepository lexiconRepository;
	
	public LexiconDTO getLexiconByCode(String code) {
		return null;/*
		return new LexiconDTO(lexiconRepository.findByCode(code).orElseThrow(
				()-> new IllegalArgumentException("code error")));
				*/
	}
	
	public void addLexicon(LexiconDTO lexicon) {lexiconRepository.save(lexicon.toLexicon());}
	
	public List<LexiconDTO> getAll() { return lexiconRepository.findAll().stream().
			map(LexiconDTO::new).collect(Collectors.toCollection(LinkedList::new));
	}
	
	public LexiconDTO createAndUpdateLexicon(LexiconDTO lexiconDTO) {
		return new LexiconDTO(lexiconRepository.save(new Lexicon(lexiconDTO)));
	}
	
	public List<LexiconDTO> getByCode(String code) {
		// return new LexiconDTO(lexiconRepository.findByCode(code).orElse(null));
		return lexiconRepository.findByCode(code).stream().map(LexiconDTO::new).collect(Collectors.toCollection(LinkedList::new));
	}
	
	public List<LexiconDTO> getByLabel(String label) {
		// return new LexiconDTO(lexiconRepository.findByCode(code).orElse(null));
		return lexiconRepository.findByLabel(label).orElseThrow(null).stream().map(LexiconDTO::new).collect(Collectors.toCollection(LinkedList::new));
	}
	
	public void deleteById(String id) {
		// return new LexiconDTO(lexiconRepository.findByCode(code).orElse(null));
		lexiconRepository.deleteById(id);		
	}
	
	
	public List<LexiconDTO> executeQSQL(String value) {
		return lexiconRepository.findFromQuery(value).stream().map(LexiconDTO::new).collect(Collectors.toCollection(LinkedList::new));
	}
	
}
