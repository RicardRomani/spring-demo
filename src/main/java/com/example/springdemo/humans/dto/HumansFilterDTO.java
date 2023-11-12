package com.example.springdemo.humans.dto;

import com.example.springdemo.humans.model.Human;

import java.util.Map;

public record HumansFilterDTO(String name, String surname, Integer age, Human.Gender gender) {

    static public HumansFilterDTO toDto(Map<String, String> params) {

        String name = params.get("name");
        String surname = params.get("surname");
        Integer age = params.get("age") != null ? Integer.parseInt(params.get("age")) : null;
        Human.Gender gender = null;
        if(params.get("gender") != null){
            Human.Gender.checkName(params.get("gender"));
            gender = Human.Gender.valueOf(params.get("gender"));
        }

        return new HumansFilterDTO(name, surname, age, gender);
    }


}
