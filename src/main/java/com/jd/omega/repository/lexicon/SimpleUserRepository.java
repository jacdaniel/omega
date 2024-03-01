package com.jd.omega.repository.lexicon;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jd.omega.domain.SimpleUser;

@Repository
public interface SimpleUserRepository extends JpaRepository<SimpleUser, String> {
	
	Optional<List<SimpleUser>> findByFirstName(String firstName);
	Optional<List<SimpleUser>> findByName(String name);
	Optional<List<SimpleUser>> findByEmail(String email);
	
	long countByFirstName(String firstName);
	long countByName(String name);
	long countByEmail(String email);
		
	
	// ===============================
	@Query(value="SELECT * FROM simple_user WHERE name LIKE ?1%", nativeQuery=true)
	List<SimpleUser> findFromQuery(@Param("value") String value);



}
