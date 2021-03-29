package com.example.dins.shemyak_semoyn.servis;

import com.example.dins.shemyak_semoyn.pojo.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> getAllPhone(int id);

    Phone getPhone(int id, int number);

    String getPhoneByNumber(String name);

    void postPhone(Phone phone, int id);

    void putPhone(Phone phone, int id, int number);

    void deletePhone(int id, int number);
}
