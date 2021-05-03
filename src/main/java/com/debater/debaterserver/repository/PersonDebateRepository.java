package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.Debate;
import com.debater.debaterserver.entity.Person;
import com.debater.debaterserver.entity.PersonDebate;
import com.debater.debaterserver.entity.PersonDebateRaw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonDebateRepository extends JpaRepository<PersonDebate, Long> {

    PersonDebate getPersonDebateByDebate_IdAndPerson_Id(Long debate_id, Long person_id);

    List<PersonDebate> getPersonDebateByDebate_Id(Long debate_id);

    List<PersonDebate> getPersonDebateByPerson_Id(Long person_id);

    boolean existsPersonDebateByDebate_IdAndPerson_Id(Long debate_id, Long person_id);

    @Transactional
    @Modifying
    @Query(value =
            "delete from person_debate as pd where pd.person_id = :person_id and pd.debate_id = :debate_id",
            nativeQuery = true)
    void deleteRawPersonDebateByDebateIdAndPersonId(
            @Param("debate_id") Long debateId,
            @Param("person_id") Long personId);

    @Transactional
    @Modifying
    @Query(value =
            "insert into person_debate (debate_id, person_id, rights_id) values (:debate_id, :person_id, :rights_id);",
            nativeQuery = true)
    void insertRawPersonDebate(@Param("debate_id") Long debateId,
                               @Param("person_id") Long personId,
                               @Param("rights_id") Long rightsId);


}
