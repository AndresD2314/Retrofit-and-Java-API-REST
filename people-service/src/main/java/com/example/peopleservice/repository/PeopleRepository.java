package com.example.peopleservice.repository;

import com.example.peopleservice.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Integer> {
}
