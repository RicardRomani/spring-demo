package com.example.springdemo.humans.service;

import com.example.springdemo.humans.dao.HumansRepository;
import com.example.springdemo.humans.dto.HumansCreateRequestBodyDTO;
import com.example.springdemo.humans.dto.HumansFilterDTO;
import com.example.springdemo.humans.dto.HumansUpdateRequestBodyDTO;
import com.example.springdemo.humans.model.Human;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumansService {

    private final HumansRepository humansRepository;

    public HumansService(HumansRepository humansRepository) {
        this.humansRepository = humansRepository;
    }

    public List<Human> getHumans(HumansFilterDTO filter) {
        return humansRepository.getHumans(filter);
    }

    public void createHuman(HumansCreateRequestBodyDTO body) {
        HumansCreateRequestBodyDTO.validate(body);
        humansRepository.createHuman(body);
    }

    public Human getHumanById(Long id) {
        return humansRepository.getHumanById(id);
    }

    public void deleteHumanById(Long id) {
        humansRepository.deleteHumanById(id);
    }

    public void updateHumanById(Long id, HumansUpdateRequestBodyDTO body) {
        HumansUpdateRequestBodyDTO.validate(body);
        humansRepository.updateHumanById(id, body);
    }
}
