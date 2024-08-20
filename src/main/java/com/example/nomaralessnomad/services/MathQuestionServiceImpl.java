package com.example.nomaralessnomad.services;

import com.example.nomaralessnomad.interfaces.QuestionService;

import java.util.Random;
public class MathQuestionServiceImpl implements QuestionService.MathQuestionService {

    private Random random;

    private final String[] operators = {"+", "-", "*", "/"};

    public MathQuestionServiceImpl() {
        this.random = new Random();
    }

    @Override
    public Question getRandomMathQuestion() {
        int a = random.nextInt((100 - -90) + 1) + -90;
        int b = random.nextInt((100 - -90) + 1) + -90;
        String c = operators[random.nextInt(operators.length)];
        if (c.equals("/") && b == 0) {
            b = 1;
        }
        String e = a + " " + c + " " + b;
        return new Question(e, null);
    }
}