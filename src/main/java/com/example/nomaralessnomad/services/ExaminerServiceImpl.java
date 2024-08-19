package com.example.nomaralessnomad.services;

import com.example.nomaralessnomad.customeException.IllegalArgument;
import com.example.nomaralessnomad.interfaces.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nomaralessnomad.repositorys.QuestionRepositoryImpl;

import java.util.*;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionRepositoryImpl questionRepository;

    private MathQuestionService mathQuestionService;

    @Autowired
    public ExaminerServiceImpl(QuestionRepositoryImpl questionRepository, MathQuestionService mathQuestionService) {
        this.questionRepository = questionRepository;
        this.mathQuestionService = mathQuestionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> questionList = new ArrayList<>(questionRepository.getAll());

        if (amount > questionList.size() || amount <= 0) {
            throw new IllegalArgument();
        }

        Random random = new Random();
        int a = random.nextInt(amount);
        int b = amount - a;

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
