package com.example.test;

import com.example.FeignApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest(classes = FeignApplication.class)
@RunWith(SpringRunner.class)
public class MQTest {
    @Autowired
    private AmqpTemplate amqpTemplate;
    
    @Test
    public void send() {
        amqpTemplate.convertAndSend("myqueue", new Date().toString());
    }


    @Test
    public void send2() {
        amqpTemplate.convertAndSend("myexange","id", new Date().toString());
    }
    
}
