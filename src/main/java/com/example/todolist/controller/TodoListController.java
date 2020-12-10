package com.example.todolist.controller;

import com.example.todolist.dto.TodoListRequest;
import com.example.todolist.dto.TodoListResponse;
import com.example.todolist.mapper.TodoListMapper;
import com.example.todolist.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
@CrossOrigin
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @Autowired
    private TodoListMapper todoListMapper;

    @GetMapping
    public List<TodoListResponse> getAll() {
        return todoListService.findAll().stream().map(todoListMapper::toResponse).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoListResponse create(@RequestBody TodoListRequest todoListRequest) {
        return todoListMapper.toResponse(todoListService.addOne(todoListMapper.toEntity(todoListRequest)));
    }

    @PutMapping("/{id}")
    public TodoListResponse update(@PathVariable String id, @RequestBody TodoListRequest todoListRequest) {
        return todoListMapper.toResponse(todoListService.update(id,todoListMapper.toEntity(todoListRequest)));
    }

    @DeleteMapping("/{id}")
    public TodoListResponse delete(@PathVariable String id) {
        return todoListMapper.toResponse(todoListService.deleteById(id));
    }

    @DeleteMapping
    public void deleteAll() {
        todoListService.deleteAll();
    }
}
