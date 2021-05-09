package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.Thesis;
import com.debater.debaterserver.entity.ThesisRaw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface ThesisRepository extends JpaRepository<Thesis, Long> {

    List<Thesis> getThesisByDebateId(Long id);


    @Transactional
    @Query(value = "insert into thesis ("+
            " intro," +
            " definition," +
            " problem," +
            " plan," +
            " case_intro," +
            " case_desc," +
            " idea," +
            " round_number," +
            " answer_id," +
            " debate_id," +
            " person_id," +
            " date_time) VALUES (" +
            " :intro," +
            " :definition," +
            " :problem," +
            " :plan," +
            " :case_intro," +
            " :case_desc," +
            " :idea," +
            " :round_number," +
            " :answer_id," +
            " :debate_id," +
            " :person_id," +
            " :date_time ) returning id;", nativeQuery = true)
    Long insertThesisRaw(
                              @Param("intro") String intro,
                              @Param("definition") String definition,
                              @Param("problem") String problem,
                              @Param("plan") String plan,
                              @Param("case_intro") String case_intro,
                              @Param("case_desc") String case_desc,
                              @Param("idea") String idea,
                              @Param("round_number") Integer round_number,
                              @Param("answer_id") Long answer_id,
                              @Param("debate_id") Long debate_id,
                              @Param("person_id") Long person_id,
                              @Param("date_time") Timestamp date_time);

    @Transactional
    @Query(value = "insert into thesis ("+
            " intro," +
            " definition," +
            " problem," +
            " plan," +
            " case_intro," +
            " case_desc," +
            " idea," +
            " round_number," +
            " debate_id," +
            " person_id," +
            " date_time) VALUES (" +
            " :intro," +
            " :definition," +
            " :problem," +
            " :plan," +
            " :case_intro," +
            " :case_desc," +
            " :idea," +
            " :round_number," +
            " :debate_id," +
            " :person_id," +
            " :date_time ) returning id;", nativeQuery = true)
    Long insertThesisRaw2(
            @Param("intro") String intro,
            @Param("definition") String definition,
            @Param("problem") String problem,
            @Param("plan") String plan,
            @Param("case_intro") String case_intro,
            @Param("case_desc") String case_desc,
            @Param("idea") String idea,
            @Param("round_number") Integer round_number,
            @Param("debate_id") Long debate_id,
            @Param("person_id") Long person_id,
            @Param("date_time") Timestamp date_time);


}
