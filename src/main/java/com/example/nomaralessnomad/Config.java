package com.example.nomaralessnomad;

import com.example.nomaralessnomad.services.MathQuestionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public MathQuestionServiceImpl mathQuestionService() {
        return new MathQuestionServiceImpl();
    }
}