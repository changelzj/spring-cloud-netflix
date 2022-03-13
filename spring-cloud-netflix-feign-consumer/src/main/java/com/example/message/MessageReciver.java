package com.example.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageReciver {
    /**
     * 接收消息
     * 声明队列 queues = ""
     * 声明并自动创建队列 queuesToDeclare = {@Queue("myqueue")} 
     * 
     * 绑定消息和交换机
     * bindings = {
     *             @QueueBinding(value = @Queue("myqueue"), exchange = @Exchange("myexange"))
     *     }
     */
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue("myqueue"), key = "id", exchange = @Exchange("myexange"))
    })
    public void receive(String message) {
        log.info(message);
    }
}
