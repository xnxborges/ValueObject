package com.br.CRUD.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.br.CRUD.exception.ResourceNotFoundExeception;
import com.br.CRUD.model.Person;
import com.br.CRUD.repository.PersonRepository;

@Repository
@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;

	public Person create(Person person) {
		return repository.save(person);

	}

	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person findbyId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeception("No records found for this ID"));
	}

	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setFistName(person.getFistName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}

	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

	/*
	 * private final AtomicLong counter = new AtomicLong();
	 * 
	 * // GET public Person create(Person person) { return person;
	 * 
	 * }
	 * 
	 * // PUT public Person update(Person person) { return person;
	 * 
	 * }
	 * 
	 * // DELETE public void delete(String id) {
	 * 
	 * }
	 * 
	 * // Mock estático do tipo GET public Person findbyId(String id) { Person
	 * person = new Person(); person.setId(counter.incrementAndGet());
	 * person.setFistName("Natan"); person.setLastName("Borges");
	 * person.setAdress("Cotia-São Paulo-Brasil"); person.setGender("Male"); return
	 * person; }
	 * 
	 * public List<Person> findAll() { List<Person> persons = new
	 * ArrayList<Person>(); for (int i = 0; i < 2; i++) { Person person =
	 * mockPerson(i); persons.add(person); } return persons;
	 * 
	 * }
	 * 
	 * // mock Dinâmico private Person mockPerson(int i) { Person person = new
	 * Person(); person.setId(counter.incrementAndGet());
	 * person.setFistName("Person name" + i); person.setLastName("Last name" + i);
	 * person.setAdress("Some adress in Brazil" + i); person.setGender("Male");
	 * return person; }
	 */

}
