package com.quest.textquest.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "game_data", schema = "text_quest_data", catalog = "")
public class GameDataEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "question")
    private String question;
    @Basic
    @Column(name = "correct_answer")
    private String correctAnswer;
    @Basic
    @Column(name = "wrong_answer")
    private String wrongAnswer;
    @Basic
    @Column(name = "next_question_id")
    private Integer nextQuestionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(String wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public Integer getNextQuestionId() {
        return nextQuestionId;
    }

    public void setNextQuestionId(Integer nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameDataEntity that = (GameDataEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(question, that.question) && Objects.equals(correctAnswer, that.correctAnswer) && Objects.equals(wrongAnswer, that.wrongAnswer) && Objects.equals(nextQuestionId, that.nextQuestionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, correctAnswer, wrongAnswer, nextQuestionId);
    }
}
