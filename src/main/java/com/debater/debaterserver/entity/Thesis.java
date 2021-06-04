package com.debater.debaterserver.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "thesis")
@ApiModel(value = "Thesis", description = "thesis table")
public class Thesis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private Long id;

    @Column(name = "title")
    @ApiModelProperty(value = "title")
    private String title;

    @Column(name = "short")
    @ApiModelProperty(value = "short")
    private String shrt;

    @Column(name = "statement")
    @ApiModelProperty(value = "statement")
    private String statement;

    @Column(name = "round_number")
    @ApiModelProperty(value = "round_number")
    private Integer roundNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    @ApiModelProperty(value = "answer_id")
    private Thesis answer;

    @OneToMany(mappedBy = "answer")
    private final Set<Thesis> answers = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debate_id")
    @ApiModelProperty(value = "debate_id")
    private Debate debate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    @ApiModelProperty(value = "person_id")
    private Person person;

    @Column(name = "date_time")
    @ApiModelProperty(value = "date_time")
    private Timestamp dateTime;

    @Column(name = "type")
    @ApiModelProperty(value = "type")
    private Integer type;

    public Thesis() { }

    public Thesis(
            Long id,
            String title,
            String shrt,
            String statement,
            Integer roundNumber,
            Integer type,
            Timestamp dateTime,
            Person person,
            Debate debate){
        this.id = id;
        this.title = title;
        this.shrt = shrt;
        this.statement = statement;
        this.dateTime = dateTime;
        this.debate = debate;
        this.person = person;
        this.roundNumber = roundNumber;
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

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Thesis getAnswer() {
        return answer;
    }

    public void setAnswer(Thesis answer) {
        this.answer = answer;
    }

    public Debate getDebate() {
        return debate;
    }

    public void setDebate(Debate debate) {
        this.debate = debate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
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
        Thesis thesis = (Thesis) o;
        return id.equals(thesis.id) && title.equals(thesis.title) && shrt.equals(thesis.shrt) && statement.equals(thesis.statement) && roundNumber.equals(thesis.roundNumber) && Objects.equals(answer, thesis.answer) && Objects.equals(answers, thesis.answers) && debate.equals(thesis.debate) && person.equals(thesis.person) && dateTime.equals(thesis.dateTime) && type.equals(thesis.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, shrt, statement, roundNumber, answer, answers, debate, person, dateTime, type);
    }

    @Override
    public String toString() {
        return "Thesis{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shrt='" + shrt + '\'' +
                ", statement='" + statement + '\'' +
                ", roundNumber=" + roundNumber +
                ", debate=" + debate +
                ", person=" + person +
                ", dateTime=" + dateTime +
                ", type=" + type +
                '}';
    }
}
