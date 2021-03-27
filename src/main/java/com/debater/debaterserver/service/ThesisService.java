package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.Thesis;
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

    public List<Thesis> findAllByDebateId(Integer id){
        return thesisRepository.findAllByDebate_Id(id);
    }

    public Thesis findThesisById(Integer id){
        return thesisRepository.findThesisById(id);
    }
}
