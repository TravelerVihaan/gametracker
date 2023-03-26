package com.vihaan.gametracker.collection;

import com.vihaan.gametracker.ModelElementMapper;
import com.vihaan.gametracker.collection.storage.sql.GamesCollectionRepository;
import com.vihaan.gametracker.collection.storage.sql.model.GamesCollectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CollectionHandler {

    private final GamesCollectionRepository gamesCollectionRepository;
    private final ModelElementMapper<GamesCollection, GamesCollectionEntity> gamesCollectionMapper;

    @Autowired
    public CollectionHandler(GamesCollectionRepository gamesCollectionRepository,
                             @Qualifier("games_collection_mapper") ModelElementMapper<GamesCollection, GamesCollectionEntity> gamesCollectionMapper) {
        this.gamesCollectionRepository = gamesCollectionRepository;
        this.gamesCollectionMapper = gamesCollectionMapper;
    }

    public GamesCollection getCollectionByName(String collectionName){
        return getCollectionByNameSorted(collectionName, SortType.ASCENDING);
    }

    public GamesCollection getCollectionByNameSorted(String collectionName, SortType sortType){
        var gamesCollection = gamesCollectionRepository.getGameCollectionByCollectionName(collectionName)
                .map(gamesCollectionMapper::convertToDomainObject).orElseGet(() -> new GamesCollection("NotFound", Collections.emptyList()));
        switch (sortType) {
            case ASCENDING -> gamesCollection.games().sort(SortType.ASCENDING.getGamesComparator());
            case DESCENDING -> gamesCollection.games().sort(SortType.DESCENDING.getGamesComparator());
            case PLATFORMS -> gamesCollection.games().sort(SortType.PLATFORMS.getGamesComparator());
            case COMPLETION_STATUS -> gamesCollection.games().sort(SortType.COMPLETION_STATUS.getGamesComparator());
        }
        return gamesCollection;
    }
}
