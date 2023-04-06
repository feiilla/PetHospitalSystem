package com.example.pethospital.service.impl;

import com.example.pethospital.mapper.QuestionMapper;
import com.example.pethospital.pojo.Question;
import com.example.pethospital.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionMapper  questionMapper;

    @Override
    public void addQuestion(Question question) {
        questionMapper.addQuestion(question);
    }

    @Override
    public List<Question> selectAllQuestion() {
        return questionMapper.selectAllQuestion();
    }

    @Override
    public int selectQuestionCount() {
        return questionMapper.selectQuestionCount();
    }

    @Override
    public void deleteQuestionById(int id) {
        questionMapper.deleteQuestionById(id);
    }

    @Override
    public void updateQuestion(Question question) { questionMapper.updateById(question); }

    @Override
    public List<Question> selectByContent(String content) {
        return questionMapper.selectByContent(content);
    }

    @Override
    public List<Question> selectByCategory(String category) {
        return questionMapper.selectByCategory(category);
    }

    @Override
    public Question selectById(int questionId) {
        return questionMapper.selectById(questionId);
    }

    @Override
    public List<Question> generatePaper(List<String> categories) {
        // 每个种类至少一道题
        List<Question> questions = new ArrayList<>(categories.size());
        for (String category : categories) {
            Question question = questionMapper.selectRandomQuestionByCategory(category);
            if (question != null) {
                questions.add(question);
            }
        }
        // 随机选择其他题目
        Random random = new Random();
        while (questions.size() < 20) {
            String category = categories.get(random.nextInt(categories.size()));
            Question question = questionMapper.selectRandomQuestionByCategory(category);
            if (question != null && !questions.contains(question)) {
                questions.add(question);
            }
        }

        return questions;
    }

    @Override
    public int calculateScore(List<Map<String, Object>> answers) {
        int score = 0;
        for (Map<String, Object> answer : answers) {
            int questionId = (int) answer.get("questionId");
            String userAnswer = (String) answer.get("userAnswer");
            Question question = questionMapper.selectById(questionId);
            if (question != null && question.getAnswer().equals(userAnswer)) {
                score += question.getScore();
            }
        }
        return score;
    }
}