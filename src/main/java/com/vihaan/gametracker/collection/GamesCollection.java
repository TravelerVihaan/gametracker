package com.vihaan.gametracker.collection;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public record GamesCollection(@NotNull @NotBlank @Size(min = 5) String name, @NotNull List<GameCollectionElement> games) {

    public static GamesCollection emptyGamesCollection(){
        return new GamesCollection("EMPTY", Collections.emptyList());
    }

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
