package com.example.springbootcondition.config;

import com.example.springbootcondition.condition.ClassCondition;
import com.example.springbootcondition.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    @Conditional(ClassCondition.class)
    public User user() {
        return new User();
    }
}
