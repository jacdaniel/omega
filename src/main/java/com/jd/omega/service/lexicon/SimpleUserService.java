package com.jd.omega.service.lexicon;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jd.omega.domain.Lexicon;
import com.jd.omega.domain.SimpleUser;
import com.jd.omega.dto.LexiconDTO;
import com.jd.omega.dto.SimpleUserDTO;
import com.jd.omega.repository.lexicon.SimpleUserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class SimpleUserService {
	
	public final SimpleUserRepository simpleUserRepository;

	public List<SimpleUserDTO> getAll() { return simpleUserRepository.findAll().stream().
			map(SimpleUserDTO::new).collect(Collectors.toCollection(LinkedList::new));
	}
	
	public SimpleUserDTO createAndUpdateSimpleUser(SimpleUserDTO simpleUserDTO) {
		return new SimpleUserDTO(simpleUserRepository.save(new SimpleUser(simpleUserDTO)));
	}
	
	
	public List<SimpleUserDTO> getByFirstName(String code) {
		return simpleUserRepository.findByFirstName(code).orElseGet(null) .stream().map(SimpleUserDTO::new).collect(Collectors.toCollection(LinkedList::new));
	}
	
	public List<SimpleUserDTO> getByName(String code) {
		return simpleUserRepository.findByName(code).orElseGet(null) .stream().map(SimpleUserDTO::new).collect(Collectors.toCollection(LinkedList::new));
	}
	
	public List<SimpleUserDTO> getByEmail(String code) {
		return simpleUserRepository.findByEmail(code).orElseGet(null) .stream().map(SimpleUserDTO::new).collect(Collectors.toCollection(LinkedList::new));
	}
	
	public void deleteById(String id) {
		simpleUserRepository.deleteById(id);		
	}
	
	// ======================
	public long count() {
		return simpleUserRepository.count();
	}
	
	public long countByFirstName(String firstName) {
		return simpleUserRepository.countByFirstName(firstName);
	}
	
	public long countByName(String name) {
		return simpleUserRepository.countByName(name);
	}
	
	public long countByEmail(String email) {
		return simpleUserRepository.countByEmail(email);
	}
	
	public List<SimpleUserDTO> executeSQL(String value) {
		return simpleUserRepository.findFromQuery(value).stream().map(SimpleUserDTO::new).collect(Collectors.toCollection(LinkedList::new));
	}
}
