package com.debater.debaterserver.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "argument")
public class Argument {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "statement")
    private String statement;

    @Column(name = "clarification")
    private String clarification;

    @Column(name = "evidence")
    private String evidence;

    @Column(name = "summary")
    private String summary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    private Argument answer;

    @OneToMany(mappedBy = "answer")
    private Set<Argument> answers = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debate_id")
    private Debate debate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "thesis_id")
    private Thesis thesis;

    public Argument(){ }

    public Argument(
            String statement,
            String clarification,
            String evidence,
            String summary
    ){
      this.statement = statement;
      this.clarification = clarification;
      this.evidence = evidence;
      this.summary = summary;
    }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getStatement() {
    return statement;
  }

  public void setStatement(String statement) {
    this.statement = statement;
  }

  public String getClarification() {
    return clarification;
  }

  public void setClarification(String clarification) {
    this.clarification = clarification;
  }

  public String getEvidence() {
    return evidence;
  }

  public void setEvidence(String evidence) {
    this.evidence = evidence;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  @Override
  public int hashCode(){
    return Objects.hash(id, statement, clarification, evidence, summary);
  }

  @Override
  public boolean equals(Object obj){
    if (this == obj) return true;
    if (obj == null || this.getClass() == obj.getClass()) return false;
    Argument argument = (Argument) obj;
    return Objects.equals(this.id, argument.id) &&
            Objects.equals(this.statement, argument.statement) &&
            Objects.equals(this.clarification, argument.clarification) &&
            Objects.equals(this.evidence, argument.evidence) &&
            Objects.equals(this.summary, argument.summary);

  }

  @Override
  public String toString(){
    return "Thesis [id = " + id +
            ", intro = " + statement +
            ", definition = " + clarification +
            ", problem = " + evidence +
            ", plan = " + summary + "];";
  }
}