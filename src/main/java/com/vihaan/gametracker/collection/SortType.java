package com.vihaan.gametracker.collection;

import java.util.Comparator;

enum SortType {
    ASCENDING(Comparator.comparing(game -> game.game().title())),
    DESCENDING(Comparator.comparing((GameCollectionElement game) -> game.game().title()).reversed()),
    PLATFORMS(Comparator.comparing(game -> game.platform().name())),
    COMPLETION_STATUS(Comparator.comparing(GameCollectionElement::completionStatus));

    private Comparator<GameCollectionElement> gamesComparator;

    SortType(Comparator<GameCollectionElement> gamesComparator) {
        this.gamesComparator = gamesComparator;
    }

    Comparator<GameCollectionElement> getGamesComparator() {
        return gamesComparator;
    }
}
