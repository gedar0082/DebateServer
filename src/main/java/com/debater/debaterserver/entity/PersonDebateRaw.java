package com.debater.debaterserver.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel(value = "PersonDebateRaw", description = "Raw using of person_debate table (only ids in class)")
public class PersonDebateRaw {

    @ApiModelProperty(value = "debateId")
    private Long debateId;
    @ApiModelProperty(value = "personId")
    private Long personId;
    @ApiModelProperty(value = "rightsId")
    private Long rightsId;

    public PersonDebateRaw(Long debateId, Long personId, Long rightsId){
        this.debateId = debateId;
        this.personId = personId;
        this.rightsId = rightsId;
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

    public Long getRightsId() {
        return rightsId;
    }

    public void setRightsId(Long rightsId) {
        this.rightsId = rightsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDebateRaw that = (PersonDebateRaw) o;
        return debateId.equals(that.debateId) && personId.equals(that.personId) && rightsId.equals(that.rightsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(debateId, personId, rightsId);
    }

    @Override
    public String toString() {
        return "PersonDebateRaw{" +
                "debateId=" + debateId +
                ", personId=" + personId +
                ", rightsId=" + rightsId +
                '}';
    }
}
