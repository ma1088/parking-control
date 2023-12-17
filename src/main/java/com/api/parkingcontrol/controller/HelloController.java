package com.api.parkingcontrol.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    @GetMapping("/")
    public String sayHello(@RequestParam(defaultValue = "you") String param) {
        return "Hello " + param;
    }
    
}
