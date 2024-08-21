package com.example.nomaralessnomad.services;

import com.example.nomaralessnomad.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.nomaralessnomad.repositorys.QuestionRepository;
import java.util.Collection;
import java.util.Random;
import java.util.Set;

@Service
@Qualifier("javaQuestionServiceImpl")
public class JavaQuestionServiceImpl implements QuestionService {

    QuestionRepository repository;

    public JavaQuestionServiceImpl(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        Question a = new Question(question, answer);
        repository.add(a);
        return a;
    }

    @Override
    public Question add(Question question) {
        repository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        repository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Set<Question> set = (Set<Question>) repository.getAll();
        return set.stream().skip(new Random().nextInt(set.size())).findFirst().orElse(null);
    }
}
