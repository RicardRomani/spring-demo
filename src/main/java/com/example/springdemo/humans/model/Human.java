package com.example.springdemo.humans.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

public class Human {

    private static long ID_GENERATOR = 0;

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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
