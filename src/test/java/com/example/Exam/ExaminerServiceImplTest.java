package com.example.Exam;

import com.example.Exam.service.ExaminerServiceImpl;
import com.example.Exam.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static com.example.Exam.Constants.FULL_QUESTION1;
import static com.example.Exam.Constants.TEST_QUESTION_SET2;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    QuestionService mock;

    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    public void getQuestionsTest() {
        when(mock.getSize()).thenReturn(1);
        when(mock.getRandomQuestion()).thenReturn(FULL_QUESTION1);
        assertEquals(TEST_QUESTION_SET2, out.getQuestions(1));
    }

    private void assertEquals(Set<Question> testQuestionSet2, Collection<Question> questions) {
    }
}
