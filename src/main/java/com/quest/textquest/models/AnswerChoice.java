package com.quest.textquest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerChoice {
    private String text;
    private boolean isCorrect;
}
