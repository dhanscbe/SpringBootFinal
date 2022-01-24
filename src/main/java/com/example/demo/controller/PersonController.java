package com.example.demo.controller;

import com.example.demo.repository.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public List<Person> allPersons(){
        return personRepository.findAll();

    }

    @GetMapping("/persons/{id}")
    public List<Person> getPersonById(@PathVariable Long id){
        return personRepository.findAllById(id);

    }

    @PostMapping("/persons")
    public Person savePersons(@RequestBody Person newPerson){
        return personRepository.save(newPerson);
    }

    @PutMapping("/persons/{id}")
    public Person updatePerson(@RequestBody Person updatePerson){
        return personRepository.save(updatePerson);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
    }
}
