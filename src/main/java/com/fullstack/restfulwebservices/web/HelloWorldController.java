package com.fullstack.restfulwebservices.web;

import com.fullstack.restfulwebservices.domain.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

    @GetMapping("/helloWorld/{name}")
    public HelloWorldBean getHelloWorldMessage(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
//        throw new RuntimeException("some error in web service...");
    }
}
