package com.debater.debaterserver.entity;

import java.util.Objects;

public class PersonDebateJson {
    private Debate debate;
    private Person personId;
    private Rights rights;

    public Debate getDebate() {
        return debate;
    }

    public void setDebate(Debate debate) {
        this.debate = debate;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }


    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDebateJson that = (PersonDebateJson) o;
        return debate.equals(that.debate) && personId.equals(that.personId) && rights.equals(that.rights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(debate, personId, rights);
    }

    @Override
    public String toString() {
        return "PersonDebateJson{" +
                "debate=" + debate +
                ", personId=" + personId +
                ", rights=" + rights +
                '}';
    }
}
