package com.vihaan.gametracker.collection.storage.sql;

import com.vihaan.gametracker.collection.storage.sql.model.GamesCollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GamesCollectionRepository extends JpaRepository<GamesCollectionEntity, Long> {

    Optional<GamesCollectionEntity> getGameCollectionByCollectionName(String collectionName);
}
