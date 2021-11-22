package com.example.restapis.controller;

import com.example.restapis.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class HelloController  {

    private final HelloService helloService;

    @GetMapping("/")
    public String hello() {
        return helloService.hello();
    }
}