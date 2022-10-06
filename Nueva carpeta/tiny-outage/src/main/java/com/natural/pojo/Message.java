package com.natural.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Message {
    private  String author;
    private  String text;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getMessage() {
        return "mensaje creado";
    }
}
