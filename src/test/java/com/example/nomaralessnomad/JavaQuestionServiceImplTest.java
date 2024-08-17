package com.example.nomaralessnomad;

import static org.junit.jupiter.api.Assertions.*;

import com.example.nomaralessnomad.services.JavaQuestionServiceImpl;
import com.example.nomaralessnomad.services.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.nomaralessnomad.repositorys.QuestionRepository;

import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceImplTest {

    private Question q1 = new Question("A?", "B");
    private Question q2 = new Question("B?", "A");
    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private JavaQuestionServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addQuestion() {
        when(repository.add(q1)).thenReturn(q1);
        Question result = service.add(q1);
        verify(repository, times(1)).add(q1);
        assertEquals(q1, result);
    }

    @Test
    void addQuestionByText() {
        String questionText = "A?";
        String answerText = "B";
        Question question = new Question(questionText, answerText);
        when(repository.add(question)).thenReturn(question);
        Question result = service.add(questionText, answerText);
        verify(repository, times(1)).add(question);
        assertEquals(question, result);
    }

    @Test
    void removeQuestion() {
        when(repository.remove(q1)).thenReturn(q1);
        Question result = service.remove(q1);
        verify(repository, times(1)).remove(q1);
        assertEquals(q1, result);
    }

    @Test
    void getAll() {
        Collection<Question> questions = Arrays.asList(q1, q2);
        when(repository.getAll()).thenReturn(questions);
        Collection<Question> result = service.getAll();
        verify(repository, times(1)).getAll();
        assertEquals(questions, result);
    }

    @Test
    void getRandomQuestion() {
        Set<Question> questions = new HashSet<>(Arrays.asList(q1, q2));
        when(repository.getAll()).thenReturn(questions);
        Question result = service.getRandomQuestion();
        verify(repository, times(1)).getAll();
        assertTrue(questions.contains(result));
    }
}
