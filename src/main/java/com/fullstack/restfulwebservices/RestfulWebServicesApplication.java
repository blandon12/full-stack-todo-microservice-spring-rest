package com.fullstack.restfulwebservices;

import com.fullstack.restfulwebservices.domain.Todo;
import com.fullstack.restfulwebservices.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class RestfulWebServicesApplication implements CommandLineRunner {

    @Autowired
    private TodoService todoService;

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServicesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("command line runner works!!!");

        Todo todo1 = new Todo("learn drupal", false, Calendar.getInstance(), Long.valueOf(1));
        todoService.saveTodo(todo1);
        Todo todo2 = new Todo("learn angular", false, Calendar.getInstance(), Long.valueOf(1));
        todoService.saveTodo(todo2);
        Todo todo3 = new Todo("learn java", false, Calendar.getInstance(), Long.valueOf(1));
        todoService.saveTodo(todo3);
        Todo todo4 = new Todo("learn php", false, Calendar.getInstance(), Long.valueOf(1));
        todoService.saveTodo(todo4);

    }
}
