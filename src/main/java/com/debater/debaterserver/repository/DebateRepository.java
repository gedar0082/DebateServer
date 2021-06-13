package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.Debate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebateRepository extends JpaRepository<Debate, Long> {


    Debate getDebateById(Long id);

    List<Debate> getDebateBy();


}
