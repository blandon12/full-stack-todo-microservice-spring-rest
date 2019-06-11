package com.fullstack.restfulwebservices.service;

import com.fullstack.restfulwebservices.domain.Todo;
import com.fullstack.restfulwebservices.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Todo deleteTodo(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        todoRepository.delete(optionalTodo.get());

        return optionalTodo.get();
    }

    @Override
    public Todo retrieveTodo(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
