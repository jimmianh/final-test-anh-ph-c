package com.javamaster.springsecurityjwt.service;

import com.javamaster.springsecurityjwt.entity.Person;
import com.javamaster.springsecurityjwt.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;



@Service
public class PersonService implements IPersonService {

	@Autowired
	private PersonRepository repository;

	@Override
	public Person getPersonByID(Long id) {

		return repository.findById(id).get();
	}

	@Override
	public void createPerson(Person person) {

		repository.save(person);
	}

	@Override
	public boolean isPersonExistsByUsername(String username) {

		return repository.existsByUsername(username);
	}

	@Override
	public Person getPersonByUsername(String username) {

		return repository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Person person = repository.findByUsername(username);

		if (person == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(person.getUsername(), person.getPassword(), Collections.emptyList());
	}

}
