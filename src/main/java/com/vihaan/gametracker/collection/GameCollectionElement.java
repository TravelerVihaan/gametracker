package com.vihaan.gametracker.collection;

import com.vihaan.gametracker.game.Game;
import com.vihaan.gametracker.game.Platform;

import java.util.Objects;

public record GameCollectionElement(Game game, Platform platform, boolean completionStatus) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCollectionElement that = (GameCollectionElement) o;
        return completionStatus == that.completionStatus && Objects.equals(game, that.game) && Objects.equals(platform, that.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, platform, completionStatus);
    }

    @Override
    public String toString() {
        return "GameCollectionEntry{" +
                "game=" + game +
                ", platform=" + platform +
                ", completionStatus=" + completionStatus +
                '}';
    }
}
