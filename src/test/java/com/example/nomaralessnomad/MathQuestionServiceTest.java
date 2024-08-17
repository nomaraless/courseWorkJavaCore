package com.example.nomaralessnomad;

import com.example.nomaralessnomad.services.MathQuestionService;
import com.example.nomaralessnomad.services.Question;
import com.example.nomaralessnomad.customeException.MethodNotAllowed;
import org.junit.jupiter.api.Test;

import static java.lang.Math.random;
import static org.junit.jupiter.api.Assertions.*;

public class MathQuestionServiceTest {
    private final MathQuestionService mathQuestionService = new MathQuestionService();

    @Test
    void add_shouldThrowMethodNotAllowed() {
        assertThrows(MethodNotAllowed.class, () -> mathQuestionService.add("2 + 2", "4"));
    }

    @Test
    void addQuestion_shouldThrowMethodNotAllowed() {
        Question question = new Question("2 + 2", "4");
        assertThrows(MethodNotAllowed.class, () -> mathQuestionService.add(question));
    }

    @Test
    void remove_shouldThrowMethodNotAllowed() {
        Question question = new Question("2 + 2", "4");
        assertThrows(MethodNotAllowed.class, () -> mathQuestionService.remove(question));
    }

    @Test
    void getAll_shouldThrowMethodNotAllowed() {
        assertThrows(MethodNotAllowed.class, () -> mathQuestionService.getAll());
    }
}

