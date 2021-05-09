package com.debater.debaterserver.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "argument")
public class Argument {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "statement")
    private String statement;

    @Column(name = "clarification")
    private String clarification;

    @Column(name = "evidence")
    private String evidence;

    @Column(name = "summary")
    private String summary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    private Argument answer;

    @OneToMany(mappedBy = "answer")
    private Set<Argument> answers = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debate_id")
    private Debate debate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "thesis_id")
    private Thesis thesis_id;

    @Column(name = "date_time")
    private Timestamp date_time;

    public Argument(){

    }


    public Argument(Integer id, String statement, String clarification, String evidence, String summary, Argument answer, Debate debate, Person person_id, Thesis thesis_id, Timestamp date_time) {
        this.id = id;
        this.statement = statement;
        this.clarification = clarification;
        this.evidence = evidence;
        this.summary = summary;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Argument argument = (Argument) o;
        return id.equals(argument.id) && statement.equals(argument.statement) && Objects.equals(clarification, argument.clarification) && Objects.equals(evidence, argument.evidence) && Objects.equals(summary, argument.summary) && Objects.equals(answer, argument.answer) && Objects.equals(answers, argument.answers) && debate.equals(argument.debate) && person_id.equals(argument.person_id) && Objects.equals(thesis_id, argument.thesis_id) && date_time.equals(argument.date_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statement, clarification, evidence, summary, debate, person_id, thesis_id, date_time);
    }

    @Override
    public String toString() {
        return "Argument{" +
                "id=" + id +
                ", statement='" + statement + '\'' +
                ", clarification='" + clarification + '\'' +
                ", evidence='" + evidence + '\'' +
                ", summary='" + summary + '\'' +
                ", answer=" + answer +
                ", answers=" + answers +
                ", debate_id=" + debate +
                ", person_id=" + person_id +
                ", thesis_id=" + thesis_id +
                ", date_time=" + date_time +
                '}';
    }
}