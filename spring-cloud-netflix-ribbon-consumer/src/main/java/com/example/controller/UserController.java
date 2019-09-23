package com.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("hello")
    @HystrixCommand(fallbackMethod = "error")
    public String hello(String message) {
        String msg = restTemplate.getForObject("http://user-provider/hello?message="+message, String.class);
        return msg;
    }
    
    public String error(String message) {
        return "error";
    }
}






