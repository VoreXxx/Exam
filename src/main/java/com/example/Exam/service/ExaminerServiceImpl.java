package com.example.Exam.service;

import com.example.Exam.Question;
import com.example.Exam.exception.InvalidQuestionRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private static final Logger log = LoggerFactory.getLogger(ExaminerServiceImpl.class);

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getSize();
        if (amount <= 0 || size < amount) {
            log.info("Wrong requested amount, should be less then " + size);
            throw new InvalidQuestionRequestException(amount, size);
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        log.info("Question were retrieved " + questions);
        return questions;
    }
}
