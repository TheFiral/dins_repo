package com.example.dins.shemyak_semoyn.pojo;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private List<Phone> book;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, ArrayList<Phone> book) {
        this.name = name;
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getBook() {
        return book;
    }

    public void setBook(List<Phone> book) {
        this.book = book;
    }

    public boolean findNameAcrossEquals(String name) {
        if (name.equals(this.name)) {
            return true;
        }
        return false;
    }



    public boolean findNameAcrossContains(String name){
        if (this.name.contains(name)) {
            return true;
        }
        return false;
    }
}
