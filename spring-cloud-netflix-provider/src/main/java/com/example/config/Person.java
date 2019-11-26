package com.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "person")
@Component
@RefreshScope
public class Person {
    private Long id;
    private Integer age;
    private String lastName;
    private String firstName;
}
