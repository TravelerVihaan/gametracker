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

    GamesCollection getGamesCollection(String collectionName);

    GamesCollection getSortedGamesCollection(String collectionName, SortType sortType);

    List<GameCollectionElement> getGamesFromCollection(String collectionName);
    List<GameCollectionElement> getCustiomizedGamesFromCollection(String collectionName, Set<GamesCollectionFilter> filters, SortType sortType);

    default List<GameCollectionElement> applyFilters(Set<GamesCollectionFilter> filters, List<GameCollectionElement> games) {
        List<GameCollectionElement> filteredGames = new ArrayList<>(games);
        for(GamesCollectionFilter gamesFilter : filters) {
            filteredGames = filteredGames.stream().filter(gamesFilter::verify).toList();
        }
        return filteredGames;
    }
}