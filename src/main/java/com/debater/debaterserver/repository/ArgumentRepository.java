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
    @Query(value = "insert into argument (" +
            " title," +
            " statement," +
            " answer_id," +
            " debate_id," +
            " thesis_id," +
            " person_id," +
            " date_time," +
            " type) " +
            "VALUES  (" +
            " :title," +
            " :statement," +
            " :answer_id," +
            " :debate_id," +
            " :thesis_id," +
            " :person_id," +
            " :date_time," +
            " :type) returning id",
            nativeQuery = true)
    Long insertArgumentRawWithAnswer(
            @Param("title") String title,
            @Param("statement") String statement,
            @Param("answer_id") Long answer_id,
            @Param("debate_id") Long debate_id,
            @Param("thesis_id") Long thesis_id,
            @Param("person_id") Long person_id,
            @Param("date_time") Timestamp date_time,
            @Param("type") Integer type
    );

    @Transactional
    @Query(value = "insert into argument (" +
            " title," +
            " statement," +
            " debate_id," +
            " thesis_id," +
            " person_id," +
            " date_time," +
            " type) " +
            "VALUES  (" +
            " :title," +
            " :statement," +
            " :debate_id," +
            " :thesis_id," +
            " :person_id," +
            " :date_time," +
            " :type) returning id",
            nativeQuery = true)
    Long insertArgumentWithoutAnswerRaw(
            @Param("title") String title,
            @Param("statement") String statement,
            @Param("debate_id") Long debate_id,
            @Param("thesis_id") Long thesis_id,
            @Param("person_id") Long person_id,
            @Param("date_time") Timestamp date_time,
            @Param("type") Integer type
    );

    @Transactional
    @Query(value = "insert into argument (" +
            " title," +
            " statement," +
            " answer_id," +
            " debate_id," +
            " person_id," +
            " date_time," +
            " type) " +
            "VALUES  (" +
            " :title," +
            " :statement," +
            " :answer_id," +
            " :debate_id," +
            " :person_id," +
            " :date_time," +
            " :type) returning id",
            nativeQuery = true)
    Long insertArgumentWithoutThesisRaw(
            @Param("title") String title,
            @Param("statement") String statement,
            @Param("answer_id") Long answer_id,
            @Param("debate_id") Long debate_id,
            @Param("person_id") Long person_id,
            @Param("date_time") Timestamp date_time,
            @Param("type") Integer type
    );

    @Transactional
    @Query(value = "insert into argument (" +
            " title," +
            " statement," +
            " debate_id," +
            " person_id," +
            " date_time," +
            " type) " +
            "VALUES  (" +
            " :title," +
            " :statement," +
            " :debate_id," +
            " :person_id," +
            " :date_time," +
            " :type) returning id",
            nativeQuery = true)
    Long insertArgumentWithoutAnswerAndThesisRaw(
            @Param("title") String title,
            @Param("statement") String statement,
            @Param("debate_id") Long debate_id,
            @Param("person_id") Long person_id,
            @Param("date_time") Timestamp date_time,
            @Param("type") Integer type
    );

}
