package com.vihaan.gametracker.collection.storage.sql;

import com.vihaan.gametracker.ModelElementMapper;
import com.vihaan.gametracker.collection.GameCollectionElement;
import com.vihaan.gametracker.collection.GamesCollection;
import com.vihaan.gametracker.collection.GamesCollectionFilter;
import com.vihaan.gametracker.collection.SortType;
import com.vihaan.gametracker.collection.storage.CollectionStorage;
import com.vihaan.gametracker.collection.storage.sql.model.GamesCollectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class CollectionSqlStorage implements CollectionStorage {

    private final GamesCollectionRepository gamesCollectionRepository;
    private final ModelElementMapper<GamesCollection, GamesCollectionEntity> gamesCollectionMapper;

    @Autowired
    public CollectionSqlStorage(GamesCollectionRepository gamesCollectionRepository,
                                ModelElementMapper<GamesCollection, GamesCollectionEntity> gamesCollectionMapper) {
        this.gamesCollectionRepository = gamesCollectionRepository;
        this.gamesCollectionMapper = gamesCollectionMapper;
    }

    public GamesCollection getGamesCollection(String collectionName){
        return getSortedGamesCollection(collectionName, SortType.ASCENDING);
    }
    public GamesCollection getSortedGamesCollection(String collectionName, SortType sortType){
        GamesCollection gamesCollection = gamesCollectionRepository.getGameCollectionByCollectionName(collectionName)
                .map(gamesCollectionMapper::convertToDomainObject)
                .orElseGet(GamesCollection::emptyGamesCollection);
        gamesCollection.games().sort(sortType.getGamesComparator());
        return gamesCollection;
    }

    @Override
    public List<GameCollectionElement> getGamesFromCollection(String collectionName) {
        return  getCustiomizedGamesFromCollection(collectionName, Collections.emptySet(), SortType.ASCENDING);
    }

    @Override
    public List<GameCollectionElement> getCustiomizedGamesFromCollection(String collectionName, Set<GamesCollectionFilter> filters, SortType sortType) {
        var gamesCollection = getGamesCollection(collectionName).games();
        gamesCollection.sort(sortType.getGamesComparator());
        return filters.isEmpty() ? gamesCollection : applyFilters(filters, gamesCollection);
    }
}
