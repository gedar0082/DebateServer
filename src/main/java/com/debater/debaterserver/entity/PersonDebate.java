package com.debater.debaterserver.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "PersonDebate")
@Table(name = "person_debate")
public class PersonDebate {

    @EmbeddedId
    private PersonDebateId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("debateId")
    private Debate debate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personId")
    private Person person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rights_id")
    private Rights rights;

    public PersonDebate(){}

    public PersonDebate(Debate debate, Person person){
        this.debate = debate;
        this.person = person;
        this.id = new PersonDebateId(debate.getId(), person.getId());
    }

    public PersonDebateId getId() {
        return id;
    }

    public void setId(PersonDebateId id) {
        this.id = id;
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

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() == obj.getClass()) return false;
        PersonDebate pd = (PersonDebate) obj;
        return Objects.equals(this.id, pd.id) &&
                Objects.equals(this.debate, pd.debate) &&
                Objects.equals(this.person, pd.person) &&
                Objects.equals(this.rights, pd.rights);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, debate, person, rights);
    }

    @Override
    public String toString(){
        return "Regulations[id = " + id +
                ", debate = " + debate.toString() +
                ", person = " + person.toString() +
                ", rights = " + rights.toString() + "];";
    }
}
