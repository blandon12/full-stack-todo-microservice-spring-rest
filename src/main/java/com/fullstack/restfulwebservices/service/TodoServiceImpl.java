package com.fullstack.restfulwebservices.service;

import com.fullstack.restfulwebservices.domain.Todo;
import com.fullstack.restfulwebservices.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Iterable<Todo> getTodos(Long uid) {
        return todoRepository.getAllByUid(uid);
    }
}
