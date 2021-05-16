package com.debater.debaterserver.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;



public class ArgumentRaw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "statement")
    private String statement;
    @Column(name = "clarification")
    private String clarification;
    @Column(name = "evidence")
    private String evidence;
    @Column(name = "summary")
    private String summary;
    @Column(name = "answer_id")
    private Long answer_id;
    @Column(name = "debate_id")
    private Long debate_id;
    @Column(name = "thesis_id")
    private Long thesis_id;
    @Column(name = "person_id")
    private Long person_id;
    @Column(name = "date_time")
    private Timestamp date_time;
    @Column(name = "type")
    private Integer type;

    public ArgumentRaw(){

    }


    public ArgumentRaw(Long id,
                       String statement,
                       String clarification,
                       String evidence,
                       String summary,
                       Long answer_id,
                       Long debate_id,
                       Long thesis_id,
                       Long person_id,
                       Timestamp date_time,
                       Integer type) {
        this.id = id;
        this.statement = statement;
        this.clarification = clarification;
        this.evidence = evidence;
        this.summary = summary;
        this.answer_id = answer_id;
        this.debate_id = debate_id;
        this.thesis_id = thesis_id;
        this.person_id = person_id;
        this.date_time = date_time;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getClarification() {
        return clarification;
    }

    public void setClarification(String clarification) {
        this.clarification = clarification;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Long answer_id) {
        this.answer_id = answer_id;
    }

    public Long getThesis_id() {
        return thesis_id;
    }

    public void setThesis_id(Long thesis_id) {
        this.thesis_id = thesis_id;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public Long getDebate_id() {
        return debate_id;
    }

    public void setDebate_id(Long debate_id) {
        this.debate_id = debate_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArgumentRaw that = (ArgumentRaw) o;
        return id.equals(that.id) && statement.equals(that.statement) && Objects.equals(clarification, that.clarification) && Objects.equals(evidence, that.evidence) && Objects.equals(summary, that.summary) && Objects.equals(answer_id, that.answer_id) && debate_id.equals(that.debate_id) && Objects.equals(thesis_id, that.thesis_id) && person_id.equals(that.person_id) && Objects.equals(date_time, that.date_time) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statement, clarification, evidence, summary, answer_id, debate_id, thesis_id, person_id, date_time, type);
    }

    @Override
    public String toString() {
        return "ArgumentRaw{" +
                "id=" + id +
                ", statement='" + statement + '\'' +
                ", clarification='" + clarification + '\'' +
                ", evidence='" + evidence + '\'' +
                ", summary='" + summary + '\'' +
                ", answer_id=" + answer_id +
                ", debate_id=" + debate_id +
                ", thesis_id=" + thesis_id +
                ", person_id=" + person_id +
                ", date_time=" + date_time +
                ", type=" + type +
                '}';
    }
}
