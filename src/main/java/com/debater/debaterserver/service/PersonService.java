package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.Person;
import com.debater.debaterserver.entity.PersonDebate;
import com.debater.debaterserver.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person getPersonById(Long id){
        return personRepository.getPersonById(id);
    }

    public Person getPersonByEmail(String email){
        return personRepository.getPersonByEmail(email);
    }

    public List<Person> getAllPersons(){
        return personRepository.getAllPersons();
    }

    public boolean existPersonById(Long id){
        return personRepository.existsPersonById(id);
    }

    public boolean existPersonByEmail(String email) { return personRepository.existsPersonByEmail(email); }

    public void deletePersonById(Long id){
        personRepository.deleteById(id);
    }

    public Person updatePerson(Person person){
        return personRepository.save(person);
    }

    public Person insertPerson(Person person){
        return personRepository.save(person);
    }








}
