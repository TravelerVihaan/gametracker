package com.vihaan.gametracker.collection.storage.sql;

import com.vihaan.gametracker.ModelElementMapper;
import com.vihaan.gametracker.collection.GameCollectionElement;
import com.vihaan.gametracker.collection.storage.sql.model.GameCollectionElementEntity;

public class GameCollectionElementMapper implements ModelElementMapper<GameCollectionElement, GameCollectionElementEntity> {
    @Override
    public GameCollectionElementEntity convertToEntity(GameCollectionElement domainObject) {
        return null;
    }

    @Override
    public GameCollectionElement convertToDomainObject(GameCollectionElementEntity domainObject) {
        return null;
    }
}
