package com.example.todolist.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document
public class TodoList {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String text;
    private Boolean done = false;
    private List<String> labelId = new ArrayList<>();

    public TodoList(String text, Boolean done, List<String> labelId) {
        this.text = text;
        this.done = done;
        this.labelId = labelId;
    }

    public TodoList() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public List<String> getLabelId() {
        return labelId;
    }

    public void setLabelId(List<String> labelId) {
        this.labelId = labelId;
    }
}
