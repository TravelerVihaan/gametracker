package com.vihaan.gametracker.collection.storage.sql;

import com.vihaan.gametracker.collection.storage.sql.model.GameCollectionElementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameCollectionElementRepository extends JpaRepository<GameCollectionElementEntity, Long> {
}
