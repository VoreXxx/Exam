package com.example.Exam.service;

import com.example.Exam.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
