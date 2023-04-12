package com.example.pethospital.service;

import com.example.pethospital.pojo.Answer;
import com.example.pethospital.pojo.Question;
import com.example.pethospital.pojo.Score;

import java.util.List;

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
    List<Score> calculateScore(List<Answer> answers);
}
