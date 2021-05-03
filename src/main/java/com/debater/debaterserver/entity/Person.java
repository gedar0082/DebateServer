package com.debater.debaterserver.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PersonDebate> personDebates = new HashSet<>();

    public Person() {}

    public Person(Long id, String nickname, String email, String password){
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() == obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(this.id, person.id) &&
                Objects.equals(this.nickname, person.nickname) &&
                Objects.equals(this.email, person.email) &&
                Objects.equals(this.password, person.password);
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public String toString(){
        return "Person[id = " + id +
                ", nickname = " + nickname +
                ", email = " + email +
                ", password = " + password + "];";
    }
}
