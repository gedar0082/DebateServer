package com.debater.debaterserver.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class ThesisRaw {

    private Long id;
    private String intro;
    private String definition;
    private String problem;
    private String plan;
    private String case_intro;
    private String case_desc;
    private String idea;
    private Integer round_number;
    private Long answer_id;
    private Long debate_id;
    private Long person_id;
    private Timestamp date_time;


    public ThesisRaw(Long id,
                     String intro,
                     String definition,
                     String problem,
                     String plan,
                     String case_intro,
                     String case_desc,
                     String idea,
                     Integer round_number,
                     Long answer_id,
                     Long debate_id,
                     Long person_id,
                     Timestamp date_time) {
        this.id = id;
        this.intro = intro;
        this.definition = definition;
        this.problem = problem;
        this.plan = plan;
        this.case_intro = case_intro;
        this.case_desc = case_desc;
        this.idea = idea;
        this.round_number = round_number;
        this.answer_id = answer_id;
        this.debate_id = debate_id;
        this.person_id = person_id;
        this.date_time = date_time;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCase_intro() {
        return case_intro;
    }

    public void setCase_intro(String case_intro) {
        this.case_intro = case_intro;
    }

    public String getCase_desc() {
        return case_desc;
    }

    public void setCase_desc(String case_desc) {
        this.case_desc = case_desc;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThesisRaw thesisRaw = (ThesisRaw) o;
        return id.equals(thesisRaw.id) && intro.equals(thesisRaw.intro) && Objects.equals(definition, thesisRaw.definition) && Objects.equals(problem, thesisRaw.problem) && Objects.equals(plan, thesisRaw.plan) && Objects.equals(case_intro, thesisRaw.case_intro) && Objects.equals(case_desc, thesisRaw.case_desc) && Objects.equals(idea, thesisRaw.idea) && round_number.equals(thesisRaw.round_number) && Objects.equals(answer_id, thesisRaw.answer_id) && debate_id.equals(thesisRaw.debate_id) && person_id.equals(thesisRaw.person_id) && date_time.equals(thesisRaw.date_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, intro, definition, problem, plan, case_intro, case_desc, idea, round_number, answer_id, debate_id, person_id, date_time);
    }

    @Override
    public String toString() {
        return "ThesisRaw{" +
                "id=" + id +
                ", intro='" + intro + '\'' +
                ", definition='" + definition + '\'' +
                ", problem='" + problem + '\'' +
                ", plan='" + plan + '\'' +
                ", case_intro='" + case_intro + '\'' +
                ", case_desc='" + case_desc + '\'' +
                ", idea='" + idea + '\'' +
                ", round_number=" + round_number +
                ", answer_id=" + answer_id +
                ", debate_id=" + debate_id +
                ", person_id=" + person_id +
                ", date_time=" + date_time +
                '}';
    }
}
