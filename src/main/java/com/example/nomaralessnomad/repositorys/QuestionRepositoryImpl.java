package com.example.nomaralessnomad.repositorys;

import com.example.nomaralessnomad.services.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    final Set<Question> questions = new HashSet<>(Set.of());

    QuestionRepositoryImpl() {}

    @PostConstruct
    void init() {
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
