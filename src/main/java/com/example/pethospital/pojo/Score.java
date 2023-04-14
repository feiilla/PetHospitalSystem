package com.example.pethospital.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    private int questionId;
    private boolean isCorrect;
    private int score;
}
