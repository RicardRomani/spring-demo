package com.example.springdemo.tests;

import com.example.springdemo.config.ApiConfig;
import com.example.springdemo.errors.ApiErrorCode;
import com.example.springdemo.errors.RicardRestException;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;


@RestController
@Validated
@RequestMapping(TestsController.BASE_URI)
public class TestsController {

    private int number;

    static final String BASE_URI = ApiConfig.BASE_URL + "/tests";

    private static final Logger logger = LoggerFactory.getLogger(TestsController.class);

    @GetMapping("hello")
    private String sayHello() {
        logger.info("This is info");
        logger.warn("This is a warn!");
        logger.error("ERROR!!");
        logger.info("Property: " + number);
        System.out.println("Log: private String sayHello()");

        return "Hello!";
    }

//    @GetMapping("my-test")
//    private Set<Map.Entry<String, String>> myTest(@RequestParam Map<String, String> params){
//        System.out.println("Log: private String myTest()");
//
//        return params.entrySet();
//    }

    //    @GetMapping("my-test")
//    private String myTest(@RequestParam @Valid @Min(1) @Max(10) Integer a,
//                          @RequestParam @Valid @NotNull String b){
//        System.out.println("Log: private String myTest()");
//
//        return String.format("a is %s, b is %s", a, b);
//    }
    private static class MyPostRequest implements Serializable {

        private static final long serialVersionUID = 1L;
        @Size(max = 10, message = "name length cannot be above 50 characters")
        private String name;

        @JsonProperty("event_id")
        private Long eventId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getEventId() {
            return eventId;
        }

        public void setEventId(Long eventId) {
            this.eventId = eventId;
        }
    }

    @PostMapping("post")
    private String doPost(@RequestBody @Valid MyPostRequest request) {
        System.out.println("Log: private String myTest()");

        return request.getName() + request.getEventId();
    }

    @GetMapping("error")
    private void throwError(){
        throw new RicardRestException(ApiErrorCode.GENERIC_DEVELOPER_ERROR);
    }
}
