package com.debater.debaterserver.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "PersonDebate")
@Table(name = "person_debate")
@ApiModel(value = "PersonDebate", description = "relation of person, debate and person rights")
public class PersonDebate {

    @EmbeddedId
    @ApiModelProperty(value = "id")
    private PersonDebateId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("debateId")
    @ApiModelProperty(value = "debateId")
    private Debate debate;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("personId")
    @ApiModelProperty(value = "personId")
    private Person person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rights_id")
    @ApiModelProperty(value = "rights_id")
    private Rights rights;

    public PersonDebate(){}

    public PersonDebate(Debate debate, Person person){
        this.debate = debate;
        this.person = person;
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
        return
                Objects.equals(this.debate, pd.debate) &&
                Objects.equals(this.person, pd.person) &&
                Objects.equals(this.rights, pd.rights);
    }

    @Override
    public int hashCode(){
        return Objects.hash( debate, person, rights);
    }

    @Override
    public String toString(){
        return "Regulations["+
                ", debate = " + debate.toString() +
                ", person = " + person.toString() +
                ", rights = " + rights.toString() + "];";
    }
}
