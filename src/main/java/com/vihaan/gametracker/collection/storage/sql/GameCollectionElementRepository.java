package com.vihaan.gametracker.collection.storage.sql;

import com.vihaan.gametracker.collection.storage.sql.model.GameCollectionElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameCollectionElementRepository extends JpaRepository<GameCollectionElement, Long> {
}
