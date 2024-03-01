package com.jd.omega.web.rest.Lexicon;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jd.omega.dto.LexiconDTO;
import com.jd.omega.service.lexicon.LexiconService;
import org.springframework.web.bind.annotation.RequestBody;

//import jakarta.persistence.EntityManagerFactory;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

// import javax.persistance.Persistance;




@RestController
@RequestMapping("/lexicon")
@AllArgsConstructor
public class LexiconResource {
	private final LexiconService lexiconService;
	
	@GetMapping("/all")
	public List<LexiconDTO> getAllLexicon(){
		return lexiconService.getAll();
	}
	
	@PostMapping("/create")
	public LexiconDTO createLexicon(
			@Valid
			@RequestBody 
			final LexiconDTO lexiconDTO
			){
		return lexiconService.createAndUpdateLexicon(lexiconDTO);
	}
	
	@GetMapping("/code/{code}")
	public List<LexiconDTO> getByCode(@PathVariable final String code) {
		return lexiconService.getByCode(code);
	}
	
	@GetMapping("/label/{label}")
	public List<LexiconDTO> getByLabel(@PathVariable final String label) {
		return lexiconService.getByLabel(label);
	}
	
	@GetMapping("/delete/{id}")
	public void deleteById(@PathVariable final String id) {
		lexiconService.deleteById(id);
	}
	
	
	@GetMapping("/testeem/{value}")
	public List<LexiconDTO> testEM(@PathVariable final String value) {
		return lexiconService.executeQSQL(value);
		
		/*
		EntityManagerFactory emf = Persistance.creteEntitymanagerFactory("mm");
		EntityManager em = getEntityManager();
		*/
		
	}
	
}
