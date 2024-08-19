package com.example.nomaralessnomad.interfaces;

import com.example.nomaralessnomad.services.Question;

import java.util.Collection;
import java.util.Random;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
