package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.Argument;
import com.debater.debaterserver.entity.ArgumentRaw;
import com.debater.debaterserver.repository.ArgumentRepository;
import com.debater.debaterserver.util.Utility;
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
        if (argumentRaw.getAnswer_id() == null){
            if (argumentRaw.getThesis_id() == null){
                return argumentRepository.insertArgumentWithoutAnswerAndThesisRaw(
                        argumentRaw.getTitle(),
                        argumentRaw.getStatement(),
                        argumentRaw.getDebate_id(),
                        argumentRaw.getPerson_id(),
                        Utility.getCurrentTimeGMT(),
                        argumentRaw.getType()
                );
            }else{
                return argumentRepository.insertArgumentWithoutAnswerRaw(
                        argumentRaw.getTitle(),
                        argumentRaw.getStatement(),
                        argumentRaw.getDebate_id(),
                        argumentRaw.getThesis_id(),
                        argumentRaw.getPerson_id(),
                        Utility.getCurrentTimeGMT(),
                        argumentRaw.getType()
                );
            }
        }else{
            if (argumentRaw.getThesis_id() == null){
                return argumentRepository.insertArgumentWithoutThesisRaw(
                        argumentRaw.getTitle(),
                        argumentRaw.getStatement(),
                        argumentRaw.getAnswer_id(),
                        argumentRaw.getDebate_id(),
                        argumentRaw.getPerson_id(),
                        Utility.getCurrentTimeGMT(),
                        argumentRaw.getType()
                );
            }else{
                return argumentRepository.insertArgumentRawWithAnswer(
                        argumentRaw.getTitle(),
                        argumentRaw.getStatement(),
                        argumentRaw.getAnswer_id(),
                        argumentRaw.getDebate_id(),
                        argumentRaw.getThesis_id(),
                        argumentRaw.getPerson_id(),
                        Utility.getCurrentTimeGMT(),
                        argumentRaw.getType()
                );
            }

        }
    }

}
