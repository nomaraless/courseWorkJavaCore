package com.example.nomaralessnomad.services;

import com.example.nomaralessnomad.interfaces.ExaminerService;
import com.example.nomaralessnomad.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("javaQuestionServiceImpl") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionServiceImpl") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Random random = new Random();
        int a = random.nextInt(amount);
        int b = amount - a;

        Set<Question> questions = new LinkedHashSet<>();

        for (int i = 0; i < a; i++) {
            questions.add(mathQuestionService.getRandomQuestion());
        }
        for (int i = 0; i < b; i++) {
            if (questions.size() <= amount) {
                questions.add(javaQuestionService.getRandomQuestion());
            }
        }
        return questions;
    }
}
