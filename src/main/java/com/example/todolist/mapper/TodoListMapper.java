package com.example.todolist.mapper;

import com.example.todolist.dto.TodoListRequest;
import com.example.todolist.dto.TodoListResponse;
import com.example.todolist.model.TodoList;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TodoListMapper {
    public TodoList toEntity(TodoListRequest todoListRequest) {
        TodoList todoList = new TodoList();
        BeanUtils.copyProperties(todoListRequest, todoList);
        return todoList;
    }

    public TodoListResponse toResponse(TodoList todoList) {
        TodoListResponse todoListResponse = new TodoListResponse();
        BeanUtils.copyProperties(todoList, todoListResponse);
        return todoListResponse;
    }
}
