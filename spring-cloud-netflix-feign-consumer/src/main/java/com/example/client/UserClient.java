package com.example.client;

import com.example.dto.UserReq;
import com.example.dto.UserResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-provider", fallback = UserClientFallback.class)
public interface UserClient {
    @GetMapping("hello")
    String hello(@RequestParam("message") String message);

    @PostMapping("get")
    UserResp getUser(@RequestBody UserReq req);
}



