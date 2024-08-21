package com.example.nomaralessnomad.controllers;

import com.example.nomaralessnomad.interfaces.QuestionService;
import com.example.nomaralessnomad.services.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathQuestionController {
    private final QuestionService mathQuestionService;

    public MathQuestionController(@Qualifier("mathQuestionServiceImpl") QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping(path = "/get")
    public Question getRandomQuestion() {
        return mathQuestionService.getRandomQuestion();
    }
}
