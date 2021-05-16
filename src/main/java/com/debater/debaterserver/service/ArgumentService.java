package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.Argument;
import com.debater.debaterserver.entity.ArgumentRaw;
import com.debater.debaterserver.repository.ArgumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArgumentService {

    @Autowired
    private final ArgumentRepository argumentRepository;

    public ArgumentService(ArgumentRepository argumentRepository){
        this.argumentRepository = argumentRepository;
    }

    public List<Argument> getArgumentsByDebateId(Long id){
        return argumentRepository.getArgumentsByDebateId(id);
    }

    public Long insertArgumentRaw(ArgumentRaw argumentRaw){

        if(argumentRaw.getThesis_id() == null){
            return argumentRepository.insertArgumentWithoutThesisRaw(argumentRaw.getStatement(),
                    argumentRaw.getClarification(),
                    argumentRaw.getEvidence(),
                    argumentRaw.getSummary(),
                    argumentRaw.getAnswer_id(),
                    argumentRaw.getDebate_id(),
                    argumentRaw.getPerson_id(),
                    argumentRaw.getDate_time(),
                    argumentRaw.getType());
        }else{
            return argumentRepository.insertArgumentRaw(argumentRaw.getStatement(),
                    argumentRaw.getClarification(),
                    argumentRaw.getEvidence(),
                    argumentRaw.getSummary(),
                    argumentRaw.getAnswer_id(),
                    argumentRaw.getDebate_id(),
                    argumentRaw.getThesis_id(),
                    argumentRaw.getPerson_id(),
                    argumentRaw.getDate_time(),
                    argumentRaw.getType());
        }
    }

    public Long insertArgumentWithoutAnswerRaw(ArgumentRaw argumentRaw){

        if(argumentRaw.getThesis_id() == null){
            return argumentRepository.insertArgumentWithoutAnswerAndThesisRaw(argumentRaw.getStatement(),
                    argumentRaw.getClarification(),
                    argumentRaw.getEvidence(),
                    argumentRaw.getSummary(),
                    argumentRaw.getDebate_id(),
                    argumentRaw.getPerson_id(),
                    argumentRaw.getDate_time(),
                    argumentRaw.getType());
        }else{
            return argumentRepository.insertArgumentWithoutAnswerRaw(argumentRaw.getStatement(),
                    argumentRaw.getClarification(),
                    argumentRaw.getEvidence(),
                    argumentRaw.getSummary(),
                    argumentRaw.getDebate_id(),
                    argumentRaw.getThesis_id(),
                    argumentRaw.getPerson_id(),
                    argumentRaw.getDate_time(),
                    argumentRaw.getType());
        }
    }
}
