package com.example.pethospital.service;

import com.example.pethospital.pojo.Question;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    void addQuestion(Question question);
    List<Question> selectAllQuestion();
    int selectQuestionCount();
    void deleteQuestionById(int id);
    void updateQuestion(Question question);
    List<Question> selectByContent(String content);
    List<Question> selectByCategory(String category);
    Question selectById(int questionId);
    List<Question> generatePaper(List<String> categories);
    int calculateScore(List<Map<String, Object>> answers);
}
