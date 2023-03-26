package com.vihaan.gametracker.game.storage.sql;

import com.vihaan.gametracker.game.storage.sql.model.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {
}
