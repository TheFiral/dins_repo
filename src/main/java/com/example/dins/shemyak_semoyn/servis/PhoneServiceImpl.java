package com.example.dins.shemyak_semoyn.servis;

import com.example.dins.shemyak_semoyn.component.ListPerson;
import com.example.dins.shemyak_semoyn.exception.PersonNotFoundException;
import com.example.dins.shemyak_semoyn.exception.PhoneNotFoundException;
import com.example.dins.shemyak_semoyn.pojo.Person;
import com.example.dins.shemyak_semoyn.pojo.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private ListPerson listPerson;

    @Override
    public List<Phone> getAllPhone(int id) {
        return listPerson.getList().get(id).getBook();
    }

    @Override
    public Phone getPhone(int id, int number) {
        checkListsSize(id,number);
        return listPerson.getList().get(id).getBook().get(number);
    }

    @Override
    public String getPhoneByNumber(String number) {
        Person person = null;
        if ((person = listPerson.getPhoneByNumber(number)) != null) {
            return "Phone with number " + number + " was found at Person with name " + person.getName();
        } else {
            return "Phone with number " + number + " wasn't found.";
        }
    }

    @Override
    public void postPhone(Phone phone, int id) {
        listPerson.getList().get(id).getBook().add(phone);
    }

    @Override
    public void putPhone(Phone phone, int id, int number) {
        checkListsSize(id,number);
        listPerson.getList().get(id).getBook().remove(number);
        listPerson.getList().get(id).getBook().add(phone);
    }

    @Override
    public void deletePhone(int id, int number) {
        checkListsSize(id,number);
        listPerson.getList().get(id).getBook().remove(number);
    }

    private void checkListsSize(int id, int number){
        if(listPerson.getList().size() <= id){
            throw new PersonNotFoundException("There is no person with id = " +
                    id + " in our list.");
        }
        if(listPerson.getList().get(id).getBook().size() <= number){
            throw new PhoneNotFoundException("There is no phone with id = " +
                    number + " at this person with id = " + id);
        }
    }
}
