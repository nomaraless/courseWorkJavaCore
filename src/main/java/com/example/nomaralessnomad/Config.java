package com.example.nomaralessnomad;

import com.example.nomaralessnomad.services.MathQuestionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class Config {
    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public MathQuestionService mathQuestionService() {
        return new MathQuestionService();
    }

}
