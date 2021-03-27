package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThesisRepository extends JpaRepository<Thesis, Long> {

    List<Thesis> findAllByDebate_Id(Integer id);

    Thesis findThesisById(Integer id);
}
