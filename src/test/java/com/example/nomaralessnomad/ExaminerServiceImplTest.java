package com.example.nomaralessnomad;

import com.example.nomaralessnomad.services.ExaminerServiceImpl;
import com.example.nomaralessnomad.services.MathQuestionService;
import com.example.nomaralessnomad.services.Question;
import com.example.nomaralessnomad.customeException.IllegalArgument;
import org.junit.jupiter.api.*;
import org.mockito.*;
import com.example.nomaralessnomad.repositorys.QuestionRepositoryImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ExaminerServiceImplTest {
    private Question q1 = new Question("A?", "A");
    private Question q2 = new Question("B?", "B");
    private Question q3 = new Question("C?", "C");
    @Mock
    private QuestionRepositoryImpl questionRepository;

    @Mock
    private MathQuestionService mathQuestionService;

    @Mock
    private Random random;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldThrowIllegalArgumentWhenAmountExceedsAvailableQuestions() {
        List<Question> questions = List.of(q1, q2);
        when(questionRepository.getAll()).thenReturn(questions);
        int amount = 3;
        assertThrows(IllegalArgument.class, () -> examinerService.getQuestions(amount));
    }

    @Test
    void shouldReturnCorrectNumberOfQuestions() {
        List<Question> questions = List.of(q1, q2, q3);
        when(questionRepository.getAll()).thenReturn(questions);
        when(random.nextInt(3)).thenReturn(1);
        when(mathQuestionService.getRandomQuestion())
                .thenReturn(new Question("V?", "V"))
                .thenReturn(new Question("X?", "X"));
        int amount = 3;
        Collection<Question> result = examinerService.getQuestions(amount);

        assertEquals(3, result.size());
        assertTrue(result.containsAll(questions.subList(0, 1)));
        verify(mathQuestionService, times(2)).getRandomQuestion();
    }

    @Test
    void shouldReturnUniqueQuestions() {
        List<Question> questions = List.of(q1,q2);
        when(questionRepository.getAll()).thenReturn(questions);
        when(random.nextInt(anyInt())).thenReturn(0, 1);
        when(mathQuestionService.getRandomQuestion())
                .thenReturn(new Question("1", "1"))
                .thenReturn(new Question("2", "2"));
        int amount = 2;
        Collection<Question> result = examinerService.getQuestions(amount);

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(q -> q.getQuestion().startsWith("1")));
    }
}