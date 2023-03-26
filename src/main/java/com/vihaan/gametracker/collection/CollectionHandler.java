package com.vihaan.gametracker.collection;

import com.vihaan.gametracker.collection.storage.sql.GamesCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionHandler {

    private final GamesCollectionRepository gamesCollectionRepository;

    @Autowired
    public CollectionHandler(GamesCollectionRepository gamesCollectionRepository) {
        this.gamesCollectionRepository = gamesCollectionRepository;
    }

    public GamesCollection getCollectionByName(String collectionName){
        return getCollectionByNameSorted(collectionName, SortType.ASCENDING);
    }

    public GamesCollection getCollectionByNameSorted(String collectionName, SortType sortType){
        return null;
    }
}
