package com.example.springdemo.qualifiers;

import com.example.springdemo.config.ApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(QualifierTestController.BASE_URI)
public class QualifierTestController {

    final public static String BASE_URI = ApiConfig.BASE_URL + "/qualifiers";

    @Qualifier("QualifierTestImpl2")
    @Autowired
    private QualifierTest qualifierTest;

    @PostMapping("/test")
    public void doSomething(){
        qualifierTest.doSomething();
    }
}
