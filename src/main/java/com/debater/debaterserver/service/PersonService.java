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

    public PersonService(PersonRepository personRepository) { this.personRepository = personRepository; }

    public List<Person> findAllPerson() {
        return personRepository.findAllPersons();
    }

    public List<Person> findAllPersonByNickname(String nickname){
        return personRepository.findAllByNickname(nickname);
    }

    public Person findPersonById(Integer id) {return personRepository.findPersonById(id);}

    public void createPerson(Person person){
        personRepository.save(person);
    }




}
