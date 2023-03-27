package com.vihaan.gametracker.collection.storage;

import com.vihaan.gametracker.collection.GameCollectionElement;
import com.vihaan.gametracker.collection.GamesCollection;
import com.vihaan.gametracker.collection.GamesCollectionFilter;
import com.vihaan.gametracker.collection.SortType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public interface CollectionStorage {

    GamesCollection getSortedGamesCollection(String collectionName, SortType sortType);

    default GamesCollection getGamesCollection(String collectionName){
        return getSortedGamesCollection(collectionName, SortType.ASCENDING);
    };
    default List<GameCollectionElement> getGamesFromCollection(String collectionName){
        return  getCustomizedGamesFromCollection(collectionName, Collections.emptySet(), SortType.ASCENDING);
    };

    default List<GameCollectionElement> getCustomizedGamesFromCollection(String collectionName, Set<GamesCollectionFilter> filters, SortType sortType){
        var gamesCollection = getGamesCollection(collectionName).games();
        gamesCollection.sort(sortType.getGamesComparator());
        return filters.isEmpty() ? gamesCollection : applyFilters(filters, gamesCollection);
    };

    private List<GameCollectionElement> applyFilters(Set<GamesCollectionFilter> filters, List<GameCollectionElement> games) {
        List<GameCollectionElement> filteredGames = new ArrayList<>(games);
        for(GamesCollectionFilter gamesFilter : filters) {
            filteredGames = filteredGames.stream().filter(gamesFilter::verify).toList();
        }
        return filteredGames;
    }
}
