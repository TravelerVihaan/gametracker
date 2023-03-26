package com.vihaan.gametracker.collection;

import java.util.List;
import java.util.Objects;

public record GamesCollection(String name, List<GameCollectionEntry> games) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamesCollection that = (GamesCollection) o;
        return Objects.equals(name, that.name) && Objects.equals(games, that.games);
    }

    @Override
    public String toString() {
        return "GamesCollection{" +
                "name='" + name + '\'' +
                ", games=" + games +
                '}';
    }
}
