package com.assignment.controller;

import com.assignment.entity.Person;
import com.assignment.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        try {
            Person savedPerson = personService.createPerson(person);
            return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
        }
        catch (Exception e) {
         return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Person by ID
    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonById(@PathVariable Integer personId) {
        Optional<Person> person = Optional.ofNullable(personService.getPersonById(personId));
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Person by ID
    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> deletePersonById(@PathVariable Integer personId) {
        personService.deletePersonById(personId);
        return ResponseEntity.noContent().build();
    }
}

