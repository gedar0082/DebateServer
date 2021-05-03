package com.debater.debaterserver.entity;

import java.util.Objects;

public class PersonAuthenticationJson {
    private String nickname;
    private String email;
    private String password;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonAuthenticationJson(){}

    public PersonAuthenticationJson(String nickname, String email, String password){
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonAuthenticationJson that = (PersonAuthenticationJson) o;
        return Objects.equals(nickname, that.nickname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, email, password);
    }

    @Override
    public String toString() {
        return "PersonAuthenticationJson{" +
                "nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
