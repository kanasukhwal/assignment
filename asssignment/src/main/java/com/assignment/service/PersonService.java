package com.assignment.service;

import com.assignment.entity.Person;
import com.assignment.exception.PersonNotFoundException;
import com.assignment.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {


    @Autowired
    private PersonRepository personRepository;

    // Create a new Person
    @Transactional
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    // Get Person by ID
    public Person getPersonById(Integer personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with ID: " + personId));
    }

    // Delete Person by ID
    public void deletePersonById(Integer personId) {
        personRepository.findById(personId).orElseThrow(() ->
                new PersonNotFoundException("Person not found with ID: " + personId));
        personRepository.deleteById(personId);
    }
}
