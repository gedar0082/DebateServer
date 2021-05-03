package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {

    Person getPersonById(Long id);

    Person getPersonByEmail(String email);

    @Query(value = "SELECT * FROM person;", nativeQuery = true)
    List<Person> getAllPersons();

    boolean existsPersonById(Long id);

    boolean existsPersonByEmail(String email);


}
