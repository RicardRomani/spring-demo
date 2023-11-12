package com.example.springdemo.humans.dto;

import com.example.springdemo.humans.model.Human;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public record HumansUpdateRequestBodyDTO(String name, String surname, Integer age, String gender) {
    public static void validate(HumansUpdateRequestBodyDTO body) {
        if(body.name() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Property 'name' is required");
        }
        if(body.surname() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Property 'surname' is required");
        }
        if(body.age() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Property 'age' is required");
        }
        if(body.age() < 1900 || body.age() > 2100){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid age");
        }
        if(body.gender() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Property 'gender' is required");
        }
        Human.Gender.checkName(body.gender());
    }
}
