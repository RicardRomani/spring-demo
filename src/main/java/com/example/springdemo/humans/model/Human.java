package com.example.springdemo.humans.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@Data
public class Human {

    private static long ID_GENERATOR = 0;

    @Setter(AccessLevel.NONE)
    private final long id;
    private String name;
    private String surname;
    private int age;
    private Gender gender;

    private Human(long id, String name, String surname, int age, Gender gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Human(String name, String surname, int age, Gender gender) {
        this(++ID_GENERATOR, name, surname, age, gender);
    }

    public enum Gender {
        M, F;

        public static void checkName(String name){
            if(Arrays.stream(Gender.values()).noneMatch(gender -> gender.name().equals(name))){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid gender");
            }
        }
    }

}
