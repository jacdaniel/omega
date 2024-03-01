package com.jd.omega.web.rest.simpleUser;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jd.omega.dto.LexiconDTO;
import com.jd.omega.dto.SimpleUserDTO;
import com.jd.omega.service.lexicon.SimpleUserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/simpleuser")
@AllArgsConstructor
public class SimpleUserResource {
	
	private final SimpleUserService simpleUserService;
	
	@GetMapping("/all")
	public List<SimpleUserDTO> getAllLexicon(){
		return simpleUserService.getAll();
	}
	
	
	@PostMapping("/create")
	public SimpleUserDTO createUser(
			@Valid
			@RequestBody 
			final SimpleUserDTO simpleUserDTO
			){
		return simpleUserService.createAndUpdateSimpleUser(simpleUserDTO);
	}
	
	@GetMapping("/firstname/{firstName}")
	public List<SimpleUserDTO> getByFirstName(@PathVariable final String firstName) {
		return simpleUserService.getByFirstName(firstName);
	}
	
	@GetMapping("/name/{name}")
	public List<SimpleUserDTO> getByName(@PathVariable final String name) {
		return simpleUserService.getByName(name);
	}
	
	@GetMapping("/email/{email}")
	public List<SimpleUserDTO> getByEmail(@PathVariable final String email) {
		return simpleUserService.getByEmail(email);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable final String id) {
		simpleUserService.deleteById(id);
	}
	
	// =========================
	@GetMapping("/count")
	public long count(){
		return simpleUserService.count();
	}
	
	@GetMapping("/count_firstname/{firstname}")
	public long countByFirstName(@PathVariable final String firstname
			){
		return simpleUserService.countByFirstName(firstname);
	}
	
	@GetMapping("/count_name/{name}")
	public long countByName(@PathVariable final String name
			){
		return simpleUserService.countByName(name);
	}
	
	@GetMapping("/count_email/{email}")
	public long countByEmail(@PathVariable final String email
			){
		return simpleUserService.countByEmail(email);
	}	
	
	@GetMapping("/request/{str}")
	public List<SimpleUserDTO> request(@PathVariable final String str){
		return simpleUserService.executeSQL(str);
	}

}
