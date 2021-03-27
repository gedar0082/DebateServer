package com.debater.debaterserver.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "link")
    private String link;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "argument_id")
    private Argument argument;

    public Link(){}

    public Link(String link) {
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, link);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() == obj.getClass()) return false;
        Link link = (Link) obj;
        return Objects.equals(this.id, link.id) &&
                Objects.equals(this.link, link.link);
    }

    @Override
    public String toString(){
        return "Thesis [id = " + id +
                ", link = " + link + "];";
    }
}
