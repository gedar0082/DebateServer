package com.debater.debaterserver.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonDebateId implements Serializable {

    @Column(name = "debate_id")
    private Long debateId;

    @Column(name = "person_id")
    private Long personId;

    public PersonDebateId(){}

    public PersonDebateId(Long debateId, Long personId){
        this.debateId = debateId;
        this.personId = personId;
    }

    public Long getDebateId() {
        return debateId;
    }

    public void setDebateId(Long debateId) {
        this.debateId = debateId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
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
