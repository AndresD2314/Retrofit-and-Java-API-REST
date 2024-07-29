package com.example.peopleservice.service;

import com.example.peopleservice.entities.People;
import com.example.peopleservice.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final PeopleRepository repository;

    public List<People> getAllPeople () {
        return this.repository.findAll();
    }

    public People getPeopleById (Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    public People createPeople (People people) {
        return this.repository.save(people);
    }

    public People updatePeople (Integer id, People people) {
        People updatePeople = this.repository.findById(id).orElse(null);

        if (updatePeople != null) {
            updatePeople.setEmail(people.getEmail());
            updatePeople.setName(people.getName());
            updatePeople.setPhone(people.getPhone());
            updatePeople.setAge(people.getAge());
            return this.repository.save(updatePeople);
        }

        return null;
    }

    public boolean deletePeople (Integer id) {
        People deletedPeople = this.repository.findById(id).orElse(null);

        if (deletedPeople != null) {
            this.repository.deleteById(deletedPeople.getId());
            return true;
        }

        return false;
    }

}
