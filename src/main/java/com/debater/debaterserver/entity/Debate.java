package com.debater.debaterserver.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "debate")
public class Debate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date_start")
    private Timestamp dateStart;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regulations_id")
    private Regulations regulations;

    @OneToMany(
            mappedBy = "debate",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PersonDebate> personDebates = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public Regulations getRegulations() {
        return regulations;
    }

    public void setRegulations(Regulations regulations) {
        this.regulations = regulations;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() == obj.getClass()) return false;
        Debate debate = (Debate) obj;
        return Objects.equals(this.id, debate.id) &&
                Objects.equals(this.description, debate.description) &&
                Objects.equals(this.name, debate.name) &&
                Objects.equals(this.dateStart, debate.dateStart) &&
                Objects.equals(this.regulations, debate.regulations) ;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, description, name, dateStart, regulations);
    }

    @Override
    public String toString(){
        return "Debate[id = " + id +
                ", name = " + name +
                ", description = " + description +
                ", dateStart = " + dateStart.toString() +
                ", description = " + regulations.toString() + "];";
    }


}
