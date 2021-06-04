package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface ThesisRepository extends JpaRepository<Thesis, Long> {

    List<Thesis> getThesisByDebateId(Long id);

    @Transactional
    @Query(value = "insert into thesis ("+
            " title," +
            " short," +
            " statement," +
            " round_number," +
            " answer_id," +
            " debate_id," +
            " person_id," +
            " date_time," +
            "type) VALUES (" +
            " :title," +
            " :shrt," +
            " :statement," +
            " :round_number," +
            " :answer_id," +
            " :debate_id," +
            " :person_id," +
            " :date_time," +
            " :type ) returning id;", nativeQuery = true)
    Long insertThesisRawWithAnswer(
                              @Param("title") String title,
                              @Param("shrt") String shrt,
                              @Param("statement") String statement,
                              @Param("round_number") Integer round_number,
                              @Param("answer_id") Long answer_id,
                              @Param("debate_id") Long debate_id,
                              @Param("person_id") Long person_id,
                              @Param("date_time") Timestamp date_time,
                              @Param("type") Integer type);

    @Transactional
    @Query(value = "insert into thesis ("+
            " title," +
            " short," +
            " statement," +
            " round_number," +
            " debate_id," +
            " person_id," +
            " date_time," +
            "type) VALUES (" +
            " :title," +
            " :shrt," +
            " :statement," +
            " :round_number," +
            " :debate_id," +
            " :person_id," +
            " :date_time," +
            " :type ) returning id;", nativeQuery = true)
    Long insertThesisRawWithoutAnswer(
            @Param("title") String title,
            @Param("shrt") String shrt,
            @Param("statement") String statement,
            @Param("round_number") Integer round_number,
            @Param("debate_id") Long debate_id,
            @Param("person_id") Long person_id,
            @Param("date_time") Timestamp date_time,
            @Param("type") Integer type);


}
