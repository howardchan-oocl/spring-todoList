package com.example.todolist.repository;

import com.example.todolist.model.TodoList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends MongoRepository<TodoList, String> {

}
