package com.colak.springtutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    // http://localhost:8080/api/v1/hello-world
    @GetMapping(value = "/hello-world")
    public String helloWorld() {
        return "hello world!!";
    }

}
