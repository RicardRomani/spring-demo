package com.example.springdemo.qualifiers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Qualifier("QualifierTestImpl2")
public class QualifierTestImpl2 implements QualifierTest {

    @Override
    public void doSomething() {
        log.info("Hello world 2");
    }
}
