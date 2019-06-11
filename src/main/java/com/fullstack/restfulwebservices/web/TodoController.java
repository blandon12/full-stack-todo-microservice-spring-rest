package com.fullstack.restfulwebservices.web;

import com.fullstack.restfulwebservices.domain.Todo;
import com.fullstack.restfulwebservices.service.TodoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/user/{uid}/todos")
    public Iterable<Todo> getTodos(@PathVariable Long uid) {
        return todoService.getTodos(uid);
    }

    @GetMapping("/user/{uid}/todos/{id}")
    public Todo getTodos(@PathVariable Long uid, @PathVariable Long id) {
        return todoService.retrieveTodo(id);
    }

    @DeleteMapping("/user/{uid}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long uid, @PathVariable Long id) {
        Todo todo = todoService.deleteTodo(id);

        if (todo != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/user/{uid}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long uid,
                                           @PathVariable Long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoService.saveTodo(todo);

        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @PostMapping("/user/{uid}/todos")
    public ResponseEntity<Todo> createTodo(@PathVariable Long uid, @RequestBody Todo todo) {
        Todo createdTodo = todoService.saveTodo(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
