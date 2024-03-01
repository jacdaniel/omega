package com.jd.omega.repository.lexicon;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jd.omega.domain.Lexicon;

@Repository
public interface LexiconRepository extends JpaRepository<Lexicon, String>{
	// Optional<Lexicon> findByCode(String code);
	List<Lexicon> findByCode(String code);
	Optional<List<Lexicon>> findByLabel(String label);
	
	
	@Query(value="SELECT * FROM framework WHERE label=:value", nativeQuery=true)
	List<Lexicon> findFromQuery(String value);
	

	
}
