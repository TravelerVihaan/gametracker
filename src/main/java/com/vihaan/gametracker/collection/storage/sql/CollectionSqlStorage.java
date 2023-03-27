package com.vihaan.gametracker.collection.storage.sql;

import com.vihaan.gametracker.ModelElementMapper;
import com.vihaan.gametracker.collection.GamesCollection;
import com.vihaan.gametracker.collection.SortType;
import com.vihaan.gametracker.collection.storage.CollectionStorage;
import com.vihaan.gametracker.collection.storage.sql.model.GamesCollectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CollectionSqlStorage implements CollectionStorage {

    private final GamesCollectionRepository gamesCollectionRepository;
    private final ModelElementMapper<GamesCollection, GamesCollectionEntity> gamesCollectionMapper;

    @Autowired
    public CollectionSqlStorage(GamesCollectionRepository gamesCollectionRepository,
                                @Qualifier("games_collection_mapper") ModelElementMapper<GamesCollection, GamesCollectionEntity> gamesCollectionMapper) {
        this.gamesCollectionRepository = gamesCollectionRepository;
        this.gamesCollectionMapper = gamesCollectionMapper;
    }

    public GamesCollection getSortedGamesCollection(String collectionName, SortType sortType){
        GamesCollection gamesCollection = gamesCollectionRepository.getGameCollectionByCollectionName(collectionName)
                .map(gamesCollectionMapper::convertToDomainObject)
                .orElseGet(GamesCollection::emptyGamesCollection);
        gamesCollection.games().sort(sortType.getGamesComparator());
        return gamesCollection;
    }
}
