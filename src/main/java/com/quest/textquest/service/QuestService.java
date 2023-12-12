package com.quest.textquest.service;

import com.quest.textquest.models.GameDataEntity;
import com.quest.textquest.repositories.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestService {

    private final QuestRepository questRepository;

    @Autowired
    public QuestService(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public GameDataEntity getQuestionById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Question ID must not be null");
        }
        return questRepository.findById(id).orElse(null);
    }
}