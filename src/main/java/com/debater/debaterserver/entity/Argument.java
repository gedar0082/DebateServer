package com.debater.debaterserver.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "argument")
@ApiModel(value = "Argument", description = "this class stored all fields as JSON, and" +
        " some complex fields, like debate_id are stored as inner JSON")
public class Argument {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private Integer id;

    @Column(name = "title")
    @ApiModelProperty(value = "argument title - varchar 1024")
    private String title;

    @Column(name = "statement")
    @ApiModelProperty(value = "statement")
    private String statement;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    @ApiModelProperty(value = "answer argument JSON")
    private Argument answer;

    @OneToMany(mappedBy = "answer")
    private final Set<Argument> answers = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debate_id")
    @ApiModelProperty(value = "debate JSON")
    private Debate debate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    @ApiModelProperty(value = "person JSON")
    private Person person_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "thesis_id")
    @ApiModelProperty(value = "thesis JSON")
    private Thesis thesis_id;

    @Column(name = "date_time")
    @ApiModelProperty(value = "current time")
    private Timestamp date_time;

    @Column(name = "type")
    @ApiModelProperty(value = "type")
    private Integer type;

    public Argument(){

    }

    public Argument(Integer id,String title, String statement, Argument answer, Debate debate, Person person_id, Thesis thesis_id, Timestamp date_time) {
        this.id = id;
        this.title = title;
        this.statement = statement;
        this.answer = answer;
        this.debate = debate;
        this.person_id = person_id;
        this.thesis_id = thesis_id;
        this.date_time = date_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Argument getAnswer() {
        return answer;
    }

    public void setAnswer(Argument answer) {
        this.answer = answer;
    }

    public Debate getDebate_id() {
        return debate;
    }

    public void setDebate_id(Debate debate) {
        this.debate = debate;
    }

    public Person getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }

    public Thesis getThesis_id() {
        return thesis_id;
    }

    public void setThesis_id(Thesis thesis_id) {
        this.thesis_id = thesis_id;
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
        Argument argument = (Argument) o;
        return id.equals(argument.id) && title.equals(argument.title) && statement.equals(argument.statement) && Objects.equals(answer, argument.answer) && Objects.equals(answers, argument.answers) && debate.equals(argument.debate) && person_id.equals(argument.person_id) && Objects.equals(thesis_id, argument.thesis_id) && date_time.equals(argument.date_time) && type.equals(argument.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, statement, answer, answers, debate, person_id, thesis_id, date_time, type);
    }

    @Override
    public String toString() {
        return "Argument{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", statement='" + statement + '\'' +
                ", debate=" + debate +
                ", person_id=" + person_id +
                ", thesis_id=" + thesis_id +
                ", date_time=" + date_time +
                ", type=" + type +
                '}';
    }
}