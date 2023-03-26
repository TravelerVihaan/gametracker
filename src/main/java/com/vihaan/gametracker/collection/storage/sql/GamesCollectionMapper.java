package com.vihaan.gametracker.collection.storage.sql;

import com.vihaan.gametracker.ModelElementMapper;
import com.vihaan.gametracker.collection.GamesCollection;
import com.vihaan.gametracker.collection.storage.sql.model.GamesCollectionEntity;
import org.springframework.stereotype.Service;

@Service("games_collection_mapper")
public class GamesCollectionMapper implements ModelElementMapper<GamesCollection, GamesCollectionEntity> {
    @Override
    public GamesCollectionEntity convertToEntity(GamesCollection domainObject) {
        return null;
    }

    @Override
    public GamesCollection convertToDomainObject(GamesCollectionEntity domainObject) {
        return null;
    }
}
