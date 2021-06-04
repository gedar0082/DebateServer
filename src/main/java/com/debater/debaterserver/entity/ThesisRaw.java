package com.debater.debaterserver.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.Objects;

@SuppressWarnings("unused")
@ApiModel(value = "ThesisRaw", description = "Raw using of thesis class (ids only)")
public class ThesisRaw {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "title")
    private String title;

    @ApiModelProperty(value = "short")
    private String shrt;

    @ApiModelProperty(value = "statement")
    private String statement;

    @ApiModelProperty(value = "round_number")
    private Integer round_number;

    @ApiModelProperty(value = "answer_id")
    private Long answer_id;

    @ApiModelProperty(value = "debate_id")
    private Long debate_id;

    @ApiModelProperty(value = "person_id")
    private Long person_id;

    @ApiModelProperty(value = "date_time")
    private Timestamp date_time;

    @ApiModelProperty(value = "type")
    private Integer type;


    public ThesisRaw(
                     String title,
                     String shrt,
                     String statement,
                     Integer round_number,
                     Long answer_id,
                     Long debate_id,
                     Long person_id,
                     Integer type) {
        this.title = title;
        this.shrt = shrt;
        this.statement = statement;
        this.round_number = round_number;
        this.answer_id = answer_id;
        this.debate_id = debate_id;
        this.person_id = person_id;
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShrt() {
        return shrt;
    }

    public void setShrt(String shrt) {
        this.shrt = shrt;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Integer getRound_number() {
        return round_number;
    }

    public void setRound_number(Integer round_number) {
        this.round_number = round_number;
    }

    public Long getAnswerId() {
        return answer_id;
    }

    public void setAnswerId(Long answer_id) {
        this.answer_id = answer_id;
    }

    public Long getDebateId() {
        return debate_id;
    }

    public void setDebateId(Long debate_id) {
        this.debate_id = debate_id;
    }

    public Long getPersonId() {
        return person_id;
    }

    public void setPersonId(Long person_id) {
        this.person_id = person_id;
    }

    public Timestamp getDateTime() {
        return date_time;
    }

    public void setDateTime(Timestamp date_time) {
        this.date_time = date_time;
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
        ThesisRaw thesisRaw = (ThesisRaw) o;
        return id.equals(thesisRaw.id) && title.equals(thesisRaw.title) && shrt.equals(thesisRaw.shrt) && statement.equals(thesisRaw.statement) && round_number.equals(thesisRaw.round_number) && Objects.equals(answer_id, thesisRaw.answer_id) && debate_id.equals(thesisRaw.debate_id) && person_id.equals(thesisRaw.person_id) && date_time.equals(thesisRaw.date_time) && type.equals(thesisRaw.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, shrt, statement, round_number, answer_id, debate_id, person_id, date_time, type);
    }

    @Override
    public String toString() {
        return "ThesisRaw{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shrt='" + shrt + '\'' +
                ", statement='" + statement + '\'' +
                ", round_number=" + round_number +
                ", answer_id=" + answer_id +
                ", debate_id=" + debate_id +
                ", person_id=" + person_id +
                ", date_time=" + date_time +
                ", type=" + type +
                '}';
    }
}
