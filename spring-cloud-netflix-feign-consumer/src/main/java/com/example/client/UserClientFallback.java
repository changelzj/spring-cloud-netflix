package com.example.client;

import com.example.dto.UserReq;
import com.example.dto.UserResp;
import org.springframework.stereotype.Component;

/**
 * 用于服务熔断，从controller里面分离处理调用错误的逻辑
 * 代替使用@HystrixCommond注解对方法逐一处理异常的做法，降低耦合
 */
@Component
public class UserClientFallback implements UserClient {

    @Override
    public String hello(String message) {
        return "service error";
    }

    @Override
    public UserResp getUser(UserReq req) {
        UserResp resp = new UserResp();
        resp.setCode(500);
        resp.setMessage("error");
        return resp;
    }
}



