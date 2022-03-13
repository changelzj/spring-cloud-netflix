package com.example.controller;

import com.example.config.Person;
import com.example.dto.User;
import com.example.dto.UserReq;
import com.example.dto.UserResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@Slf4j
public class UserController {
    
    @Value("${server.port}")
    private String port;
    @Value("${user.name}")
    private String user;
    @Autowired
    private Person person;

    @GetMapping("hello")
    public String hello(@RequestParam("message") String message) {
        return message + ", port: " + port;
    }
    
    @PostMapping("get")
    public UserResp getUser(@RequestBody UserReq req) {
        UserResp resp = new UserResp();
        resp.setUser(new User());
        return resp;
    }

    @RequestMapping("config")
    public String testconfig() {
        log.info(person.toString());
        return this.user;
    }
    
}



