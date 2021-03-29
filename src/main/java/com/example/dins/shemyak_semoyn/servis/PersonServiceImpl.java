package com.example.dins.shemyak_semoyn.servis;

import com.example.dins.shemyak_semoyn.component.ListPerson;
import com.example.dins.shemyak_semoyn.exception.PersonNotFoundException;
import com.example.dins.shemyak_semoyn.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private ListPerson listPerson;

    @Override
    public List<Person> getAllPerson() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ListPerson.class);
//        List<Person> list = context.getBean("listPerson",ListPerson.class).getList();
//        context.close();
        return listPerson.getList();
    }

    @Override
    public Person getPerson(int id) {
        checkListSize(id);
        return listPerson.getList().get(id);
    }

    @Override
    public String getPersonByName(String name) {
        Person person = null;
        if ((person = listPerson.getPersonByName(name)) != null) {
            return "Person with name " + person.getName() + " was found.";
        } else {
            return "Person with name " + name + " wasn't found.";
        }
    }

    @Override
    public void postPerson(Person person) {
        listPerson.getList().add(person);
    }

    @Override
    public void putPerson(Person person, int id) {
        checkListSize(id);
        listPerson.getList().remove(id);
        listPerson.getList().add(person);
    }


    @Override
    public void deletePerson(int id) {
        checkListSize(id);
        listPerson.getList().remove(id);
    }

    private void checkListSize(int id){
        if(listPerson.getList().size() <= id){
            throw new PersonNotFoundException("There is no person with id = " +
                    id + " in our list.");
        }
    }
}
