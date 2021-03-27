package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.Person;
import com.debater.debaterserver.entity.PersonDebate;
import com.debater.debaterserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM person;", nativeQuery = true)
    List<Person> findAllPersons();

    List<Person> findAllByNickname(String nickname);

    Person findPersonById(Integer id);




}
