package com.quest.textquest.repositories;

import com.quest.textquest.models.GameDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepository extends JpaRepository<GameDataEntity, Integer> {
}
