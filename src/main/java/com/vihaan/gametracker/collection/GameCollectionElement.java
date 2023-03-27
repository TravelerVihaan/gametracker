package com.vihaan.gametracker.collection;

import com.vihaan.gametracker.game.Game;
import com.vihaan.gametracker.game.Platform;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public record GameCollectionElement(@NotNull Game game, @NotNull Platform platform, boolean completionStatus, @NotNull @NotBlank String collectionName) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCollectionElement that = (GameCollectionElement) o;
        return completionStatus == that.completionStatus && Objects.equals(game.title(), that.game.title()) && platform == that.platform && Objects.equals(collectionName, that.collectionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game.title(), platform, completionStatus, collectionName);
    }

    @Override
    public String toString() {
        return "GameCollectionEntry{" +
                "game=" + game.title() +
                ", platform=" + platform +
                ", completionStatus=" + completionStatus +
                '}';
    }
}
