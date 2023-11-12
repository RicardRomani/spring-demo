
package com.example.springdemo.humans.dao;

import com.example.springdemo.humans.dto.HumansCreateRequestBodyDTO;
import com.example.springdemo.humans.dto.HumansFilterDTO;
import com.example.springdemo.humans.dto.HumansUpdateRequestBodyDTO;
import com.example.springdemo.humans.model.Human;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HumansRepository {

    private static final List<Human> humansDB = new ArrayList<>();

    static {
        humansDB.add(new Human("Ricard", "Romaní", 1995, Human.Gender.M));
        humansDB.add(new Human("Joana", "Jacome", 1996, Human.Gender.F));
    }

    public List<Human> getHumans(HumansFilterDTO filter) {
        return humansDB.stream()
                .filter(human -> filter.name() == null || human.getName().equals(filter.name()))
                .filter(human -> filter.surname() == null || human.getSurname().equals(filter.surname()))
                .filter(human -> filter.age() == null || human.getAge() == filter.age())
                .filter(human -> filter.gender() == null || human.getGender().equals(filter.gender()))
                .toList();
    }


    public void createHuman(HumansCreateRequestBodyDTO body) {
        Human human = new Human(body.name(), body.surname(), body.age(), Human.Gender.valueOf(body.gender()));
        humansDB.add(human);
    }

    public Human getHumanById(Long id) {
        Optional<Human> human = humansDB.stream().filter(e -> e.getId() == id.intValue()).findFirst();
        if(human.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Human not found!");
        }
        return human.get();
    }

    public void deleteHumanById(Long id) {
        Human human = getHumanById(id);
        humansDB.remove(human);
    }

    public void updateHumanById(Long id, HumansUpdateRequestBodyDTO body) {
        Human human = getHumanById(id);
        int index = humansDB.indexOf(human);
        human.setName(body.name());
        human.setSurname(body.surname());
        human.setAge(body.age());
        human.setGender(Human.Gender.valueOf(body.gender()));
        humansDB.set(index, human);
    }
}
