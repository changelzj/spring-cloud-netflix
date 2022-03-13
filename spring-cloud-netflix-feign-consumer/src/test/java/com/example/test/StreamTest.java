package com.example.test;

import com.example.FeignApplication;
import com.example.message.StreamClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = FeignApplication.class)
@RunWith(SpringRunner.class)
public class StreamTest {
    
    @Autowired
    private StreamClient streamClient;
    
    @Test
    public void testSend() {
        Message<String> message = MessageBuilder.withPayload("hello").build();
        streamClient.output().send(message);
    }
    
}
