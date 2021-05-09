package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.Thesis;
import com.debater.debaterserver.entity.ThesisRaw;
import com.debater.debaterserver.repository.DebateRepository;
import com.debater.debaterserver.repository.ThesisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThesisService {

    @Autowired
    private final ThesisRepository thesisRepository;

    public ThesisService(ThesisRepository thesisRepository){
        this.thesisRepository = thesisRepository;
    }

    public List<Thesis> getThesesByDebateId(Long id){
        return thesisRepository.getThesisByDebateId(id);
    }

    public Thesis insertThesis(Thesis thesis){
        return thesisRepository.save(thesis);
    }

    public Long insertThesisRaw(ThesisRaw thesis){
        return thesisRepository.insertThesisRaw(thesis.getIntro(),
                thesis.getDefinition(), thesis.getProblem(), thesis.getPlan(), thesis.getCase_intro(),
                thesis.getCase_desc(), thesis.getIdea(), thesis.getRound_number(), thesis.getAnswerId(),
                thesis.getDebateId(), thesis.getPersonId(), thesis.getDateTime());
    }

    public Long insertThesisRaw2(ThesisRaw thesis){
        return thesisRepository.insertThesisRaw2(thesis.getIntro(),
                thesis.getDefinition(), thesis.getProblem(), thesis.getPlan(), thesis.getCase_intro(),
                thesis.getCase_desc(), thesis.getIdea(), thesis.getRound_number(),
                thesis.getDebateId(), thesis.getPersonId(), thesis.getDateTime());
    }


}
