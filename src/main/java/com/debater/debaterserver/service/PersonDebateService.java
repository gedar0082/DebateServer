package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.PersonDebate;
import com.debater.debaterserver.entity.PersonDebateRaw;
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

    public PersonDebate getPersonDebateByDebate_IdAndPerson_Id(Long debate_id, Long person_Id){
        return personDebateRepository.getPersonDebateByDebate_IdAndPerson_Id(debate_id, person_Id);
    }

    public List<PersonDebate> getPersonDebateByDebate_Id(Long debate_id){
        return personDebateRepository.getPersonDebateByDebate_Id(debate_id);
    }

    public List<PersonDebate> getPersonDebateByPerson_Id(Long person_id){
        return personDebateRepository.getPersonDebateByPerson_Id(person_id);
    }

    public void updatePersonDebate(PersonDebate personDebate){
        personDebateRepository.save(personDebate);
    }

    public void deletePersonDebate(PersonDebateRaw pdr){
        personDebateRepository.deleteRawPersonDebateByDebateIdAndPersonId(pdr.getDebateId(), pdr.getPersonId());
    }

    public void insertPersonDebate(PersonDebate personDebate){
        personDebateRepository.save(personDebate);
    }

    public void insertRawPersonDebate(PersonDebateRaw pdr){
        personDebateRepository.insertRawPersonDebate(pdr.getDebateId(), pdr.getPersonId(), pdr.getRightsId());
    }




}
