package com.debater.debaterserver.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "regulations")
@ApiModel(value = "Regulations", description = "debate regulations table")
public class Regulations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private Integer id;

    @Column(name = "rule_type")
    @ApiModelProperty(value = "rule_type")
    private Integer ruleType;


    public Regulations(){}

    public Regulations(Integer ruleType){
        this.ruleType = ruleType;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getRuleType() { return ruleType; }

    public void setRuleType(Integer ruleType) { this.ruleType = ruleType; }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() == obj.getClass()) return false;
        Regulations reg = (Regulations) obj;
        return Objects.equals(this.id, reg.id) &&
                Objects.equals(this.ruleType, reg.ruleType);
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ruleType == null) ? 0 : ruleType.hashCode());
        return result;
    }

    @Override
    public String toString(){
        return "Regulations[id = " + id + ", ruleType = " + ruleType + "];";
    }


}
