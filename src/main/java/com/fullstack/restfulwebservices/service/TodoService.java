package com.fullstack.restfulwebservices.service;

import com.fullstack.restfulwebservices.domain.Todo;

import java.util.List;

public interface TodoService {

    Iterable<Todo> getTodos(Long uid);

    Todo deleteTodo(Long id);

    Todo retrieveTodo(Long id);

    Todo saveTodo(Todo todo);
}
