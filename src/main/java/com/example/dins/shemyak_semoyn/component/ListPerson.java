package com.example.dins.shemyak_semoyn.component;

import com.example.dins.shemyak_semoyn.pojo.Person;
import com.example.dins.shemyak_semoyn.pojo.Phone;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("listPerson")
@Scope("singleton")
public class ListPerson {

    private List<Person> list;

    public ListPerson() {
        this.list = new ArrayList<>();

        list.add(new Person("Sem", createListNumber()));
        list.add(new Person("Rem", createListNumber()));
        list.add(new Person("Gen", createListNumber()));
        list.add(new Person("Ben", createListNumber()));
        list.add(new Person("Ken", createListNumber()));
    }

    public ArrayList<Phone> createListNumber() {
        ArrayList<Phone> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Phone());
        }
        return list;
    }

    public List<Person> getList() {
        return list;
    }

    public Person getPersonByName(String name) {
        for (Person person : list) {
            if (person.findNameAcrossEquals(name)) {
                return person;
            }
        }
        for (Person person : list) {
            if (person.findNameAcrossContains(name)) {
                return person;
            }
        }
        return null;
    }

    public Person getPhoneByNumber(String number) {
        for (Person person : list) {
            for (Phone phone : person.getBook()) {
                if(phone.findNumberAcrossEquals(number)){
                    return person;
                }
            }
        }
        return null;
    }
}
