package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.Debate;
import com.debater.debaterserver.repository.DebateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebateService {

    @Autowired
    private final DebateRepository debateRepository;

    public DebateService(DebateRepository debateRepository){
        this.debateRepository = debateRepository;
    }

    public List<Debate> findAllDebate(){
        return debateRepository.findDebateBy();
    }

}
