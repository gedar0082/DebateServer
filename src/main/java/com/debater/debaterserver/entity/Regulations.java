package com.debater.debaterserver.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "regulations")
public class Regulations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "rule_type")
    private Integer ruleType;

    @Column(name = "has_referee")
    private Integer hasReferee;

    public Regulations(){}

    public Regulations(Integer ruleType, Integer hasReferee){
        this.ruleType = ruleType;
        this.hasReferee = hasReferee;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getRuleType() { return ruleType; }

    public void setRuleType(Integer ruleType) { this.ruleType = ruleType; }

    public Integer getHasReferee() { return hasReferee; }

    public void setHasReferee(Integer hasReferee) { this.hasReferee = hasReferee; }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() == obj.getClass()) return false;
        Regulations reg = (Regulations) obj;
        return Objects.equals(this.id, reg.id) &&
                Objects.equals(this.ruleType, reg.ruleType) &&
                Objects.equals(this.hasReferee, reg.hasReferee);
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ruleType == null) ? 0 : ruleType.hashCode());
        result = prime * result + ((hasReferee == null) ? 0 : hasReferee.hashCode());
        return result;
    }

    @Override
    public String toString(){
        return "Regulations[id = " + id + ", ruleType = " + ruleType + ", hasReferee = " + hasReferee + "];";
    }


}
