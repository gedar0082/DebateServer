package com.debater.debaterserver.service;

import com.debater.debaterserver.repository.RightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RightsService {

    @Autowired
    RightsRepository rightsRepository;

    public RightsService(RightsRepository rightsRepository){
        this.rightsRepository = rightsRepository;
    }

    public void deleteRightById(Long id){
        rightsRepository.deleteById(id);
    }
}
