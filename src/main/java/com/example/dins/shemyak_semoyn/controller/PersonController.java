package com.example.dins.shemyak_semoyn.controller;

import com.example.dins.shemyak_semoyn.pojo.Person;
import com.example.dins.shemyak_semoyn.servis.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }

    @GetMapping("/name/{name}")
    public String getPersonByName(@PathVariable String name){
        return personService.getPersonByName(name);
    }

    @PostMapping
    public Person postPerson(@RequestBody Person person) {
        personService.postPerson(person);
        return person;
    }

    @PutMapping("{id}")
    public Person putPerson(@RequestBody Person person, @PathVariable int id) {
        personService.putPerson(person, id);
        return person;
    }

    @DeleteMapping("{id}")
    public String deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
        return "Person with ID " + id + " was deleted!";
    }
}
