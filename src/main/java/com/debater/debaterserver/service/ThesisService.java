package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.Thesis;
import com.debater.debaterserver.entity.ThesisRaw;
import com.debater.debaterserver.repository.ThesisRepository;
import com.debater.debaterserver.util.Utility;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThesisService {

    private final ThesisRepository thesisRepository;

    public ThesisService(ThesisRepository thesisRepository){
        this.thesisRepository = thesisRepository;
    }

    public List<Thesis> getThesesByDebateId(Long id){
        return thesisRepository.getThesisByDebateId(id);
    }

    public Long insertThesisRaw(ThesisRaw thesis){

        if (thesis.getAnswerId() == null){
            return thesisRepository.insertThesisRawWithoutAnswer(
                    thesis.getTitle(),
                    thesis.getShrt(),
                    thesis.getStatement(),
                    thesis.getRound_number(),
                    thesis.getDebateId(),
                    thesis.getPersonId(),
                    Utility.getCurrentTimeGMT(),
                    thesis.getType());
        }else {
            return thesisRepository.insertThesisRawWithAnswer(
                    thesis.getTitle(),
                    thesis.getShrt(),
                    thesis.getStatement(),
                    thesis.getRound_number(),
                    thesis.getAnswerId(),
                    thesis.getDebateId(),
                    thesis.getPersonId(),
                    Utility.getCurrentTimeGMT(),
                    thesis.getType()
            );
        }
    }


}
