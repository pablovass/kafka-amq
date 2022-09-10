package com.pablovass;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleMessage {
    private final Integer id;
    private String message;


    @JsonCreator
    public SampleMessage(@JsonProperty("id") Integer id, @JsonProperty("message") String message) {
        this.id = id;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "SampleMessage{" +
                "message='" + message + '\'' +
                ", id=" + id +
                '}';
    }
}
