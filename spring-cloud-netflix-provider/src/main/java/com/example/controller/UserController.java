package com.example.controller;

import com.example.dto.User;
import com.example.dto.UserReq;
import com.example.dto.UserResp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Value("${server.port}")
    private String port;

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

    
}



