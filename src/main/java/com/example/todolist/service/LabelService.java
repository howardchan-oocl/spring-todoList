package com.example.todolist.service;

import com.example.todolist.model.Label;
import com.example.todolist.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {
    @Autowired
    private LabelRepository labelRepository;

    public List<Label> findAll() {
        return labelRepository.findAll();
    }

    public Label addOne(Label label) {
        return labelRepository.insert(label);
    }

    public Label deleteById(String id) {
        if(labelRepository.existsById(id)){
            Label label = labelRepository.findById(id).get();
            labelRepository.deleteById(id);
            return label;
        }
        return null;
    }

    public void deleteAll() {
        labelRepository.deleteAll();
    }
}
