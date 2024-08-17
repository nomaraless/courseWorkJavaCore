package com.example.nomaralessnomad.repositorys;

import com.example.nomaralessnomad.services.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
