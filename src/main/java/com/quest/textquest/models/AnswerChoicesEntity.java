package com.quest.textquest.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "answer_choices", schema = "text_quest_data", catalog = "")
public class AnswerChoicesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "choice")
    private String choice;
    @Basic
    @Column(name = "game_data_id")
    private Integer gameDataId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Integer getGameDataId() {
        return gameDataId;
    }

    public void setGameDataId(Integer gameDataId) {
        this.gameDataId = gameDataId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerChoicesEntity that = (AnswerChoicesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(choice, that.choice) && Objects.equals(gameDataId, that.gameDataId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, choice, gameDataId);
    }
}
