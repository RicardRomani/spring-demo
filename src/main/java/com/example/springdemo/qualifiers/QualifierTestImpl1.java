package com.example.springdemo.qualifiers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QualifierTestImpl1 implements QualifierTest {

    @Override
    public void doSomething() {
        log.info("Hello world 1");
    }
}
