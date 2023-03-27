package com.vihaan.gametracker.collection;

import java.util.Comparator;

public enum SortType {
    ASCENDING(Comparator.comparing(game -> game.game().title()), "asc"),
    DESCENDING(Comparator.comparing((GameCollectionElement game) -> game.game().title()).reversed(), "desc"),
    PLATFORMS(Comparator.comparing(game -> game.platform().name()), "platform"),
    COMPLETION_STATUS(Comparator.comparing(GameCollectionElement::completionStatus), "completed");

    private Comparator<GameCollectionElement> gamesComparator;
    private String sortTypeName;

    SortType(Comparator<GameCollectionElement> gamesComparator, String sortTypeName) {
        this.gamesComparator = gamesComparator;
        this.sortTypeName = sortTypeName;
    }

    public Comparator<GameCollectionElement> getGamesComparator() {
        return gamesComparator;
    }

    @Override
    public String toString() {
        return sortTypeName;
    }
}
