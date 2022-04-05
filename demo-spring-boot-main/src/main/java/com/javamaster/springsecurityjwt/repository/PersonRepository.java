package com.javamaster.springsecurityjwt.repository;

import com.javamaster.springsecurityjwt.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
	boolean existsByUsername(String username);

	Person findByUsername(String username);

}
