package com.debater.debaterserver.entity;

import java.util.Objects;

public class BodyMessageJson {

    private String message;

    public BodyMessageJson(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyMessageJson that = (BodyMessageJson) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return "BodyMessageJson{" +
                "message='" + message + '\'' +
                '}';
    }
}
