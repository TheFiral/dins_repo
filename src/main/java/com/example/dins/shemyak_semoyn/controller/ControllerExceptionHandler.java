package com.example.dins.shemyak_semoyn.controller;


import com.example.dins.shemyak_semoyn.exception.DataException;
import com.example.dins.shemyak_semoyn.exception.PersonNotFoundException;
import com.example.dins.shemyak_semoyn.exception.PhoneNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<DataException> handle(PersonNotFoundException exception){
        DataException data = new DataException();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<DataException> handle(PhoneNotFoundException exception){
        DataException data = new DataException();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
