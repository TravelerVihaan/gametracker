package com.vihaan.gametracker.game;

import java.util.Objects;
import java.util.Set;

public record Game(String title, Set<Platform> platforms) {
    //TODO image icon


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(title, game.title) && Objects.equals(platforms, game.platforms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, platforms);
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", platforms=" + platforms +
                '}';
    }
}
