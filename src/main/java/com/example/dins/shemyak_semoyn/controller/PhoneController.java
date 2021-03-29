package com.example.dins.shemyak_semoyn.controller;

import com.example.dins.shemyak_semoyn.pojo.Phone;
import com.example.dins.shemyak_semoyn.servis.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/{id}")
    public List<Phone> getAllPhone(@PathVariable int id) {
        return phoneService.getAllPhone(id);
    }

    @GetMapping("/{id}/{number}")
    public Phone getPhone(@PathVariable int id, @PathVariable int number) {
        return phoneService.getPhone(id, number);
    }

    @GetMapping("/number/{number}")
    public String getPhoneByNumber(@PathVariable String number) {
        return phoneService.getPhoneByNumber(number);
    }

    @PostMapping("/{id}")
    public Phone postPhone(@RequestBody Phone phone, @PathVariable int id) {
        phoneService.postPhone(phone, id);
        return phone;
    }

    @PutMapping("/{id}/{number}")
    public Phone putPhone(@RequestBody Phone phone, @PathVariable int id, @PathVariable int number) {
        phoneService.putPhone(phone, id, number);
        return phone;
    }

    @DeleteMapping("{id}/{number}")
    public String deletePhone(@PathVariable int id, @PathVariable int number) {
        phoneService.deletePhone(id, number);
        return "Number with ID " + id + " was deleted at the person by " + id + " !";
    }
}
