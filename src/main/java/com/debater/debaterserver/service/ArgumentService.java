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
        return argumentRepository.insertArgumentRaw(argumentRaw.getStatement(),
                argumentRaw.getClarification(),
                argumentRaw.getEvidence(),
                argumentRaw.getSummary(),
                argumentRaw.getAnswer_id(),
                argumentRaw.getDebate_id(),
                argumentRaw.getThesis_id(),
                argumentRaw.getPerson_id(),
                argumentRaw.getDate_time());
    }

    public Long insertArgumentWithoutAnswerRaw(ArgumentRaw argumentRaw){
        return argumentRepository.insertArgumentWithoutAnswerRaw(argumentRaw.getStatement(),
                argumentRaw.getClarification(),
                argumentRaw.getEvidence(),
                argumentRaw.getSummary(),
                argumentRaw.getDebate_id(),
                argumentRaw.getThesis_id(),
                argumentRaw.getPerson_id(),
                argumentRaw.getDate_time());
    }
}
