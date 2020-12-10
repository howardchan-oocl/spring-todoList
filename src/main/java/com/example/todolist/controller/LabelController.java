package com.example.todolist.controller;

import com.example.todolist.dto.LabelRequest;
import com.example.todolist.dto.LabelResponse;
import com.example.todolist.dto.TodoListResponse;
import com.example.todolist.mapper.LabelMapper;
import com.example.todolist.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/labels")
@CrossOrigin
public class LabelController {
    @Autowired
    private LabelService labelService;

    @Autowired
    private LabelMapper labelMapper;

    @GetMapping
    public List<LabelResponse> getAll() {
        return labelService.findAll().stream().map(labelMapper::toResponse).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LabelResponse create(@RequestBody LabelRequest labelRequest) {
        return labelMapper.toResponse(labelService.addOne(labelMapper.toEntity(labelRequest)));
    }

    @DeleteMapping("/{id}")
    public LabelResponse delete(@PathVariable String id) {
        return labelMapper.toResponse(labelService.deleteById(id));
    }

    @DeleteMapping
    public void deleteAll() {
        labelService.deleteAll();
    }
}
