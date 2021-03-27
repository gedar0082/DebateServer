package com.debater.debaterserver.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "thesis")
public class Thesis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "intro")
    private String intro;

    @Column(name = "definition")
    private String definition;

    @Column(name = "problem")
    private String problem;

    @Column(name = "plan")
    private String plan;

    @Column(name = "case_intro")
    private String caseIntro;

    @Column(name = "case_desc")
    private String caseDesc;

    @Column(name = "round_number")
    private Integer roundNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    private Thesis answer;

    @OneToMany(mappedBy = "answer")
    private Set<Thesis> answers = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debate_id")
    private Debate debate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    public Thesis() { }

    public Thesis(
            String intro,
            String definition,
            String plan,
            String caseIntro,
            String caseDesc,
            Integer roundNumber){
        this.intro = intro;
        this.definition = definition;
        this.plan = plan;
        this.caseIntro = caseIntro;
        this.caseDesc = caseDesc;
        this.roundNumber = roundNumber;
    }

    public Thesis(String intro){
        this.intro = intro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getCaseIntro() {
        return caseIntro;
    }

    public void setCaseIntro(String caseIntro) {
        this.caseIntro = caseIntro;
    }

    public String getCaseDesc() {
        return caseDesc;
    }

    public void setCaseDesc(String caseDesc) {
        this.caseDesc = caseDesc;
    }

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, intro, definition, problem, plan, caseIntro, caseDesc, roundNumber);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() == obj.getClass()) return false;
        Thesis thesis = (Thesis) obj;
        return Objects.equals(this.id, thesis.id) &&
                Objects.equals(this.intro, thesis.intro) &&
                Objects.equals(this.definition, thesis.definition) &&
                Objects.equals(this.problem, thesis.problem) &&
                Objects.equals(this.plan, thesis.plan) &&
                Objects.equals(this.caseIntro, thesis.caseIntro) &&
                Objects.equals(this.caseDesc, thesis.caseDesc) &&
                Objects.equals(this.roundNumber, thesis.roundNumber);
    }

    @Override
    public String toString(){
        return "Thesis [id = " + id +
                ", intro = " + intro +
                ", definition = " + definition +
                ", problem = " + problem +
                ", plan = " + plan +
                ", caseIntro = " + caseIntro +
                ", caseDesc = " + caseDesc +
                ", roundNumber = " + roundNumber + "];";
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
}
