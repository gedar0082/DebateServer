package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.Debate;
import com.debater.debaterserver.entity.Person;
import com.debater.debaterserver.entity.PersonDebate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonDebateRepository extends JpaRepository<PersonDebate, Long> {


    List<PersonDebate> findPersonDebateByPerson_Nickname(String nickname);

    List<PersonDebate> findPersonDebateByPerson_Id(Integer id);

    List<PersonDebate> findPersonDebateByDebate_Id(Integer id);


}
