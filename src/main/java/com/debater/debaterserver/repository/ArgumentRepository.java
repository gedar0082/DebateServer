package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.Argument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArgumentRepository extends JpaRepository<Argument, Long> {

    List<Argument> getArgumentByThesis_Id(Integer id);

    List<Argument> getArgumentByDebate_id(Integer id);

    Argument findArgumentById(Integer id);
}
