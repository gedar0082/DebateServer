package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.Debate;
import com.debater.debaterserver.repository.DebateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class DebateService {

    @Autowired
    private final DebateRepository debateRepository;

    public DebateService(DebateRepository debateRepository){
        this.debateRepository = debateRepository;
    }

    public Debate getDebateById(Long id){
        return debateRepository.getDebateById(id);
    }

    public List<Debate> getAllDebates(){
        return debateRepository.getDebateBy();
    }

    public boolean existsDebateById(Long id){
        return debateRepository.existsDebateById(id);
    }

    public void deleteDebateById(Long id){
        debateRepository.deleteById(id);
    }

    public void updateDebate(Debate debate){
        debateRepository.save(debate);
    }

    public Debate insertDebate(Debate debate){
        return debateRepository.save(debate);
    }

}
