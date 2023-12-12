package com.quest.textquest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "game_data", schema = "text_quest_data")
public class GameDataEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "question")
    private String question;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Column(name = "wrong_answer")
    private String wrongAnswer;

    @Column(name = "next_question_id")
    private Integer nextQuestionId;

    @OneToMany(mappedBy = "gameData", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnswerChoicesEntity> answerChoices;
}