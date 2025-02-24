package com.example.pethospital.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 试题
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private int questionId; // 试题ID
    private String category;    // 试题对应病种
    private String content; // 试题内容
    private String optionA; // 选项A
    private String optionB; // 选项B
    private String optionC; // 选项C
    private String optionD; // 选项D
    private String answer;  // 试题答案
    private int score;  // 试题分值
}
