package com.debater.debaterserver.service;

import com.debater.debaterserver.entity.Debate;
import com.debater.debaterserver.repository.DebateRepository;
import com.debater.debaterserver.util.Utility;
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

    public Debate getDebateById(Long id){
        return debateRepository.getDebateById(id);
    }

    public List<Debate> getAllDebates(){
        return debateRepository.getDebateBy();
    }

    public void deleteDebateById(Long id){
        debateRepository.deleteById(id);
    }

    public void updateDebate(Debate debate){
        debateRepository.save(debate);
    }

    public Debate insertDebate(Debate debate){
        Debate correctedTimeDebate = debate;
        correctedTimeDebate.setDateStart(Utility.getCurrentTimeGMT());
        return debateRepository.save(correctedTimeDebate);
    }

}
