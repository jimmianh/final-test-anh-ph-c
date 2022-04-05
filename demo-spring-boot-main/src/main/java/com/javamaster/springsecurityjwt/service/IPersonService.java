package com.javamaster.springsecurityjwt.service;

import com.javamaster.springsecurityjwt.entity.Person;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IPersonService extends UserDetailsService {

	Person getPersonByID(Long id);

	void createPerson(Person person);

	boolean isPersonExistsByUsername(String username);

	Person getPersonByUsername(String username);

}
