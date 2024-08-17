package com.example.nomaralessnomad.services;

import com.example.nomaralessnomad.customeException.IllegalArgument;
import com.example.nomaralessnomad.interfaces.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.nomaralessnomad.repositorys.QuestionRepositoryImpl;

import java.util.*;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    Random random;

    QuestionRepositoryImpl questionRepository;

    MathQuestionService mathQuestionService;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("random") Random random, QuestionRepositoryImpl questionRepository, @Qualifier("mathQuestionService") MathQuestionService mathQuestionService) {
        this.questionRepository = questionRepository;
        this.mathQuestionService = mathQuestionService;
        this.random = random;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> questionList = new ArrayList<>(questionRepository.getAll());
        System.out.println("1");

        if (amount > questionList.size() || amount <= 0) {
            throw new IllegalArgument();
        }
        System.out.println("7");
        Random random = new Random();
        int a = random.nextInt(amount);
        int b = amount - a;
        System.out.println("2");
        Set<Question> questions = new LinkedHashSet<>();
        for (int i = 0; i < b; i++) {
            questions.add(mathQuestionService.getRandomQuestion());
        }
        for (int i = 0; i < a; i++) {
            if (questions.size() <= amount) {
                questions.add(questionList.get(i));
            }
        }
        return questions;
    }
}
