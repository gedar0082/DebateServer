package com.debater.debaterserver.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


@ApiModel(value = "ArgumentRaw", description = "this class stored all fields as JSON, and" +
        " some complex fields, like debate_id are stored as inner JSON" )
public class ArgumentRaw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private Long id;

    @Column(name = "title")
    @ApiModelProperty(value = "title")
    private String title;

    @Column(name = "statement")
    @ApiModelProperty(value = "statement")
    private String statement;

    @Column(name = "answer_id")
    @ApiModelProperty(value = "answer_id")
    private Long answer_id;

    @Column(name = "debate_id")
    @ApiModelProperty(value = "debate_id")
    private Long debate_id;

    @Column(name = "thesis_id")
    @ApiModelProperty(value = "thesis_id")
    private Long thesis_id;

    @Column(name = "person_id")
    @ApiModelProperty(value = "person_id")
    private Long person_id;

    @Column(name = "date_time")
    @ApiModelProperty(value = "date_time")
    private Timestamp date_time;

    @Column(name = "type")
    @ApiModelProperty(value = "type")
    private Integer type;

    public ArgumentRaw(){

    }


    public ArgumentRaw(Long id,
                       String title,
                       String statement,
                       Long answer_id,
                       Long debate_id,
                       Long thesis_id,
                       Long person_id,
                       Timestamp date_time,
                       Integer type) {
        this.id = id;
        this.title = title;
        this.statement = statement;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
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
        return id.equals(that.id) && title.equals(that.title) && statement.equals(that.statement) && Objects.equals(answer_id, that.answer_id) && debate_id.equals(that.debate_id) && Objects.equals(thesis_id, that.thesis_id) && person_id.equals(that.person_id) && date_time.equals(that.date_time) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, statement, answer_id, debate_id, thesis_id, person_id, date_time, type);
    }

    @Override
    public String toString() {
        return "ArgumentRaw{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", statement='" + statement + '\'' +
                ", answer_id=" + answer_id +
                ", debate_id=" + debate_id +
                ", thesis_id=" + thesis_id +
                ", person_id=" + person_id +
                ", date_time=" + date_time +
                ", type=" + type +
                '}';
    }
}
