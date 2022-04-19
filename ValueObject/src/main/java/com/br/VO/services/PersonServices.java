package com.br.VO.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.br.VO.converter.DozerConverter;
import com.br.VO.data.model.Person;
import com.br.VO.data.vo.PersonVO;
import com.br.VO.repository.PersonRepository;


@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;

	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
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
