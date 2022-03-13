package com.example.controller;

import com.example.client.UserClient;
import com.example.dto.UserReq;
import com.example.dto.UserResp;
import com.example.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserClient userClient;
    @Autowired
    private StreamClient streamClient;

    @GetMapping("hello")
    String hello(String message) {
        String msg = userClient.hello(message);
        return msg;
    }

    @PostMapping("get")
    UserResp getUser(@RequestBody UserReq req) {
        UserResp resp = userClient.getUser(req);
        return resp;
    }
    
    @GetMapping("send")
    public String send(String msg) {
        streamClient.output().send( MessageBuilder.withPayload(msg).build() );
        return "success";
    }
}





