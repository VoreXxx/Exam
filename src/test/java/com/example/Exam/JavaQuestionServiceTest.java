package com.example.Exam;

import com.example.Exam.service.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;

import static com.example.Exam.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService();

    @Test
    void shouldAddQuestion() {
        out.add(QUESTION1, ANSWER1);
        assertTrue(out.getAll().contains(FULL_QUESTION1));
    }

    @Test
    void shouldRemoveQuestion() {
        out.remove(QUESTION1, ANSWER1);
        assertFalse(out.getAll().contains(FULL_QUESTION1));
    }

    @Test
    void shouldGetAll() {
        out.add(QUESTION1, ANSWER1);
        out.add(QUESTION2, ANSWER2);
        out.add(QUESTION3, ANSWER3);
        assertTrue(out.getAll().containsAll(List.of(FULL_QUESTION1, FULL_QUESTION2, FULL_QUESTION3)));
    }

    @Test
    void shouldGetRandomQuestion() {
        out.add(QUESTION1, ANSWER1);
        out.add(QUESTION2, ANSWER2);

        Random random = mock(Random.class, withSettings().withoutAnnotations());
        when(random.nextInt(anyInt())).thenReturn(1);

        out.setRandom(random);
        assertEquals(FULL_QUESTION1, out.getRandomQuestion());
    }
}
