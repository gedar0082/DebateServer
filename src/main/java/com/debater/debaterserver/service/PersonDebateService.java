package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.PersonDebate;
import com.debater.debaterserver.repository.PersonDebateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDebateService {

    @Autowired
    private final PersonDebateRepository personDebateRepository;

    public PersonDebateService(PersonDebateRepository personDebateRepository){
        this.personDebateRepository = personDebateRepository;
    }

    public List<PersonDebate> findPersonDebateByPersonNickname(String nickname) {
        return personDebateRepository.findPersonDebateByPerson_Nickname(nickname);
    }

    public List<PersonDebate> findPersonDebateByPersonId(Integer id){
        return personDebateRepository.findPersonDebateByPerson_Id(id);
    }

    public List<PersonDebate> findPersonDebateByDebateId(Integer id){
        return personDebateRepository.findPersonDebateByDebate_Id(id);
    }

    public void createPersonDebate(PersonDebate personDebate){
        personDebateRepository.save(personDebate);
    }


}
