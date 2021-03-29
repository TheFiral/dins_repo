package com.example.dins.shemyak_semoyn.servis;

import com.example.dins.shemyak_semoyn.pojo.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPerson();

    Person getPerson(int id);

    String getPersonByName(String name);

    void postPerson(Person person);

    void putPerson(Person person,int id);

    void deletePerson(int id);
}
