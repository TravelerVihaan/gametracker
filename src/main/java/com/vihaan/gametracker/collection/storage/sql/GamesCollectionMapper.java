package com.vihaan.gametracker.collection.storage.sql;

import com.vihaan.gametracker.ModelElementMapper;
import com.vihaan.gametracker.collection.GameCollectionElement;
import com.vihaan.gametracker.collection.GamesCollection;
import com.vihaan.gametracker.collection.storage.sql.model.GameCollectionElementEntity;
import com.vihaan.gametracker.collection.storage.sql.model.GamesCollectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("games_collection_mapper")
public class GamesCollectionMapper implements ModelElementMapper<GamesCollection, GamesCollectionEntity> {

    private ModelElementMapper<GameCollectionElement, GameCollectionElementEntity> gameMapper;

    @Autowired
    public GamesCollectionMapper(@Qualifier("game_collection_element_mapper") ModelElementMapper<GameCollectionElement, GameCollectionElementEntity> gameMapper) {
        this.gameMapper = gameMapper;
    }

    @Override
    public GamesCollectionEntity convertToEntity(GamesCollection domainObject) {
        List<GameCollectionElementEntity> games = domainObject.games().stream().map(gameMapper::convertToEntity).toList();
        return new GamesCollectionEntity(domainObject.name(), games);
    }

    @Override
    public GamesCollection convertToDomainObject(GamesCollectionEntity entityObject) {
        List<GameCollectionElement> games = entityObject.getGames().stream().map(gameMapper::convertToDomainObject).toList();
        return new GamesCollection(entityObject.getCollectionName(), games);
    }
}
