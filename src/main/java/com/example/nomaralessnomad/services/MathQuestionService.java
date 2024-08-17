package com.example.nomaralessnomad.services;

import com.example.nomaralessnomad.customeException.MethodNotAllowed;
import com.example.nomaralessnomad.interfaces.QuestionService;

import java.util.Collection;
import java.util.Random;

public class MathQuestionService implements QuestionService {

    Random random;

    private final String[] operators = {"+", "-", "*", "/"};

    public MathQuestionService() {
    }

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowed();
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowed();
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowed();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowed();
    }

    @Override
    public Question getRandomQuestion() {
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