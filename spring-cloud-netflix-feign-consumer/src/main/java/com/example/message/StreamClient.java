package com.example.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 为Stream消息编写的接口
 */
public interface StreamClient {
    @Input("in")
    SubscribableChannel input();
    
    @Output("out")
    MessageChannel output();

    @Input("inputback")
    SubscribableChannel inputback();

    @Output("outputback")
    MessageChannel outputback();
}
