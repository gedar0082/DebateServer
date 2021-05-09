package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.ArgumentRaw;
import com.debater.debaterserver.repository.ArgumentRawRepository;
import com.debater.debaterserver.repository.ArgumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class ArgumentRawService {


    private final ArgumentRawRepository argumentRawRepository;

    public ArgumentRawService(ArgumentRawRepository argumentRawRepository){
        this.argumentRawRepository = argumentRawRepository;
    }

    public List<ArgumentRaw> getArgs(Long id){
        return argumentRawRepository.getArgumentRaw(id);
    }




}
