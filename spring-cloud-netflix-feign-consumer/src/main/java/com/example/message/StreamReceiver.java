package com.example.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {
    
    @StreamListener("in")
    @SendTo("outputback")
    public String reveive(Object val) {
        log.info(val.toString());
        // 返回消息到SendTo对应队列
        return "handled";
    }

    @StreamListener("inputback")
    public void reveiveBack(Object val) {
        log.info(val.toString());
    }
}
