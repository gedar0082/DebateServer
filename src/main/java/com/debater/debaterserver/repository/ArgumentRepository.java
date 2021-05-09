package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.Argument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface ArgumentRepository extends JpaRepository<Argument, Long> {

    List<Argument> getArgumentsByDebateId(Long id);

    @Transactional
    @Query(value = "insert into argument (statement, clarification, evidence, summary, answer_id, debate_id, thesis_id, person_id, date_time) " +
            "VALUES  (:statement, :clarification, :evidence, :summary, :answer_id, :debate_id, :thesis_id, :person_id, :date_time) returning id",
            nativeQuery = true)
    Long insertArgumentRaw(
            @Param("statement") String statement,
            @Param("clarification") String clarification,
            @Param("evidence") String evidence,
            @Param("summary") String summary,
            @Param("answer_id") Long answer_id,
            @Param("debate_id") Long debate_id,
            @Param("thesis_id") Long thesis_id,
            @Param("person_id") Long person_id,
            @Param("date_time") Timestamp date_time
    );

    @Transactional
    @Query(value = "insert into argument (statement, clarification, evidence, summary, debate_id, thesis_id, person_id, date_time) " +
            "VALUES  (:statement, :clarification, :evidence, :summary, :debate_id, :thesis_id, :person_id, :date_time) returning id",
            nativeQuery = true)
    Long insertArgumentWithoutAnswerRaw(
            @Param("statement") String statement,
            @Param("clarification") String clarification,
            @Param("evidence") String evidence,
            @Param("summary") String summary,
            @Param("debate_id") Long debate_id,
            @Param("thesis_id") Long thesis_id,
            @Param("person_id") Long person_id,
            @Param("date_time") Timestamp date_time
    );

}
