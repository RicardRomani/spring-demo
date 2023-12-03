package com.example.springdemo.jackson;

import com.example.springdemo.config.ApiConfig;
import com.example.springdemo.errors.ApiErrorCode;
import com.example.springdemo.errors.ErrorCode;
import com.example.springdemo.errors.RicardRestException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(JacksonController.BASE_URI)
public class JacksonController {

    static final String BASE_URI = ApiConfig.BASE_URL + "/jackson";

    @PostMapping("test")
    public void test(@RequestBody JsonNode jsonNode) {
        log.info(jsonNode.toString());
    }

    @PostMapping("readTree")
    public JsonNode readTree(@RequestBody String string) {
        try {
            return new ObjectMapper().readTree(string);
        } catch (JsonProcessingException e) {
            throw new RicardRestException(ApiErrorCode.GENERIC_DEVELOPER_ERROR);
        }
    }

    @PostMapping("readTree2")
    public JsonNode readTree2(@RequestBody String string) {
        JsonNode jsonNode;
        try {
            jsonNode = new ObjectMapper().readTree(string);
        } catch (JsonProcessingException e) {
            throw new RicardRestException(ApiErrorCode.GENERIC_DEVELOPER_ERROR);
        }
        if (jsonNode.has("object")) {
            return jsonNode.get("object");
        }
        ((ObjectNode) jsonNode).put("new_prop", "test");
        return jsonNode;
    }

    @Data
    static class Unit {
        @JsonIgnore
        private int id;
        @NotNull(message = "Name can't be null")
        private String name;
        @NotNull(message = "Age can't be null")
        @Min(value = 1, message = "Age must be greater than 0")
        @Max(value = 150, message = "Age must be less than 150")
        private int age;
        @JsonProperty("prop_a")
        private String propA;
        @Valid
        private Address address;

        @Data
        private static class Address {
            private String country;
            @NotNull(message="City can't be null")
            private String city;
        }

    }

    @PostMapping("conversion")
    public Unit conversion(@RequestBody JsonNode jsonNode) {
        Unit unit;
        try {
            unit = new ObjectMapper().convertValue(jsonNode, Unit.class);
            log.info(unit.toString());
            return unit;
        } catch (Exception e) {
            throw new RicardRestException(ApiErrorCode.GENERIC_DEVELOPER_ERROR);
        }
    }

    @PostMapping("conversion2")
    public Unit conversion(@RequestBody @Valid Unit unit) {
        log.info(unit.toString());
        return unit;
    }


}
