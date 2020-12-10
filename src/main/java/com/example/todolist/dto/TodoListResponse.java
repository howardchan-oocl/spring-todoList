package com.example.todolist.dto;

import com.example.todolist.model.Label;

import java.util.ArrayList;
import java.util.List;

public class TodoListResponse {
    private String id;
    private String text;
    private Boolean done = false;
    private List<String> labelId = new ArrayList<>();

    public TodoListResponse(String id, String text, Boolean done, List<String> labelId) {
        this.id = id;
        this.text = text;
        this.done = done;
        this.labelId = labelId;
    }

    public TodoListResponse() {

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
