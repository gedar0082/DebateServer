package com.debater.debaterserver.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel(value = "BodyMessageJson", description = "class for error message in response")
public class BodyMessageJson {

    @ApiModelProperty(value = "message")
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
