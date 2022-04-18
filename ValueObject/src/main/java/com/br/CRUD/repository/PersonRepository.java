package com.br.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.CRUD.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
