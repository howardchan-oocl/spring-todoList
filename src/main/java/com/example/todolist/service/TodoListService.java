package com.example.todolist.service;

import com.example.todolist.model.TodoList;
import com.example.todolist.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {
    @Autowired
    private TodoListRepository todoListRepository;

    public List<TodoList> findAll() {
        return todoListRepository.findAll();
    }

    public TodoList addOne(TodoList todoList) {
        return todoListRepository.insert(todoList);
    }

    public TodoList deleteById(String id) {
        if (todoListRepository.existsById(id)) {
            TodoList todoList = todoListRepository.findById(id).get();
            todoListRepository.deleteById(id);
            return todoList;
        }
        return null;
    }

    public void deleteAll() {
        todoListRepository.deleteAll();
    }

    public TodoList update(String id, TodoList todoList) {
        if (todoListRepository.existsById(id)) {
            todoList.setId(id);
            return todoListRepository.save(todoList);
        }
        return null;
    }
}
