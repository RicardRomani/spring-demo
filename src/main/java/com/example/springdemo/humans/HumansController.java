package com.example.springdemo.humans;


import com.example.springdemo.config.ApiConfig;
import com.example.springdemo.humans.dto.HumansCreateRequestBodyDTO;
import com.example.springdemo.humans.dto.HumansFilterDTO;
import com.example.springdemo.humans.dto.HumansUpdateRequestBodyDTO;
import com.example.springdemo.humans.model.Human;
import com.example.springdemo.humans.service.HumansService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(HumansController.BASE_URI)
public class HumansController {

    static final String BASE_URI = ApiConfig.BASE_URL + "/humans";
    private static final Logger LOGGER = LoggerFactory.getLogger(HumansController.class);
    private final HumansService humansService;

    public HumansController(HumansService humansService) {
        this.humansService = humansService;
    }

    @GetMapping
    private List<Human> getHumans(@RequestParam Map<String, String> params) {
        LOGGER.info("GET /humans");
        return humansService.getHumans(HumansFilterDTO.toDto(params));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void createHuman(@RequestBody HumansCreateRequestBodyDTO body) {
        LOGGER.info("POST /humans");
        humansService.createHuman(body);
    }

    @GetMapping("/{id}")
    private Human getHumanById(@PathVariable Long id) {
        LOGGER.info("GET /humans/" + id);
        return humansService.getHumanById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void updateHumanById(@PathVariable Long id, @RequestBody HumansUpdateRequestBodyDTO body){
        LOGGER.info("PUT /humans/" + id);
        humansService.updateHumanById(id, body);
    }

    @DeleteMapping("/{id}")
    private void deleteHumanById(@PathVariable("id") Long id) {
        LOGGER.info("DELETE /humans/" + id);
        humansService.deleteHumanById(id);
    }


}
