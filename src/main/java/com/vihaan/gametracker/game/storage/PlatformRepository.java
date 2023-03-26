package com.vihaan.gametracker.game.storage;

import com.vihaan.gametracker.game.storage.sql.model.PlatformEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<PlatformEntity, Long> {
}
