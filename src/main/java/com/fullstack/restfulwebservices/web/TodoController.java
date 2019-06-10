package com.fullstack.restfulwebservices.web;

import com.fullstack.restfulwebservices.domain.Todo;
import com.fullstack.restfulwebservices.service.TodoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos/userid/{uid}")
    public Iterable<Todo> getTodos(@PathVariable Long uid) {
        return todoService.getTodos(uid);
    }
}
