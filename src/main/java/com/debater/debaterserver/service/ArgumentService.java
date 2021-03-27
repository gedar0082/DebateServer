package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.Argument;
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

    public List<Argument> getArgumentByThesis_Id(Integer id){
        return argumentRepository.getArgumentByThesis_Id(id);
    }

    public List<Argument> getArgumentByDebate_id(Integer id){
        return argumentRepository.getArgumentByDebate_id(id);
    }

    public Argument getArgumentById(Integer id){
        return argumentRepository.findArgumentById(id);
    }
}
