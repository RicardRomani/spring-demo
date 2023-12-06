package com.example.springdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

//    @EventListener(ContextRefreshedEvent.class)
//    public void logOnStart(){
//        log.info("Application started!");
//
//        System.out.print("Select value: ");
//
//        Scanner scanner = new Scanner(System.in);
//        int value = scanner.nextInt();
//        log.info("Selected value: " + value);
//    }

}
