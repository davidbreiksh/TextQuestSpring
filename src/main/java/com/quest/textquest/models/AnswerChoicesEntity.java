package com.quest.textquest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answer_choices", schema = "text_quest_data")
public class AnswerChoicesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "choice")
    private String choice;

    @Column(name = "next_question_id")
    private Integer nextQuestionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_data_id", referencedColumnName = "id")
    private GameDataEntity gameData;
}