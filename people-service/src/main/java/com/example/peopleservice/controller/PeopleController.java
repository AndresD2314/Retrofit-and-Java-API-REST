package com.example.peopleservice.controller;

import com.example.peopleservice.entities.People;
import com.example.peopleservice.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/people")
public class PeopleController {

    private final PeopleService service;

    @GetMapping
    public ResponseEntity<List<People>> getAllPeople() {
        List<People> people = this.service.getAllPeople();

        if (people != null && !people.isEmpty())
            return new ResponseEntity<>(people, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> getPeopleById(@PathVariable Integer id) {
        People people = this.service.getPeopleById(id);

        if (people != null)
            return new ResponseEntity<>(people, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<People> createPeople(@RequestBody People people) {
        People createdPeople = this.service.createPeople(people);

        if (createdPeople != null)
            return new ResponseEntity<>(createdPeople, HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<People> updatePeople(@PathVariable Integer id, @RequestBody People people) {
        People updatedPeople = this.service.updatePeople(id, people);

        if (updatedPeople != null)
            return new ResponseEntity<>(updatedPeople, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeople(@PathVariable Integer id) {
        boolean isDeleted = this.service.deletePeople(id);

        if (isDeleted)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
