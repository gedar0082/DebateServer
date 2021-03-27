package com.debater.debaterserver.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonDebateId implements Serializable {

    @Column(name = "debate_id")
    private Integer debateId;

    @Column(name = "person_id")
    private Integer personId;

    public PersonDebateId(){}

    public PersonDebateId(Integer debateId, Integer personId){
        this.debateId = debateId;
        this.personId = personId;
    }

    public Integer getDebateId() {
        return debateId;
    }

    public void setDebateId(Integer debateId) {
        this.debateId = debateId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() == obj.getClass()) return false;
        PersonDebateId pdi = (PersonDebateId) obj;
        return Objects.equals(this.debateId, pdi.debateId) &&
                Objects.equals(this.personId, pdi.personId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(debateId, personId);
    }

    @Override
    public String toString(){
        return "PersonDebateId[debateId = " + debateId + ", personId = " + personId + "];";
    }
}
