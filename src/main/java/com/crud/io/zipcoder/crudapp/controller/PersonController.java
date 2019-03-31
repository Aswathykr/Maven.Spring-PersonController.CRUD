package com.crud.io.zipcoder.crudapp.controller;

import com.crud.io.zipcoder.crudapp.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crud.io.zipcoder.crudapp.repository.PersonRepository;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/people")
    public Person createPerson(@RequestBody Person person){
        System.out.println("received Post :");
        return personRepository.save(person);
    }

    @GetMapping("/ping")
    public String ping(){
        System.out.println("received ping :");
        return "hi There";
    }

    @GetMapping("/people/{id}")
    public Person getPerson(@PathVariable long id){
        return personRepository.findOne(id);
    }
    @GetMapping("/people/")
    public List<Person> getAllPerson(){
        return (List<Person>)personRepository.findAll();
    }

    @PutMapping("/people/{id}")
    public Person updatePerson(@PathVariable long id, @RequestBody Person person){
        person.setId(id);
        return personRepository.save(person);
    }
    @DeleteMapping("/people/{id}")
    public void DeletePerson(@PathVariable long id){
        personRepository.delete(id);
    }
}
