package org.mattpayne.fun.jpa.cucumber.simplejpa.repositories;


import org.mattpayne.fun.jpa.cucumber.simplejpa.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}

