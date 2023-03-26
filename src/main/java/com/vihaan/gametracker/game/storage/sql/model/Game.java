package com.vihaan.gametracker.game.storage.sql.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game")
    private Long id;

    @Column(name = "game_title", nullable = false, unique = true)
    private String gameTitle;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "games_platforms",
            joinColumns = {@JoinColumn(name = "game_id",
                    referencedColumnName = "id_game")},
            inverseJoinColumns = {@JoinColumn(name = "platform_id",
                referencedColumnName = "id_platform")})
    private Set<Platform> availablePlatforms;

    public Game() {}
    public Game(Long id, String gameTitle, Set<Platform> availablePlatforms) {
        this.id = id;
        this.gameTitle = gameTitle;
        this.availablePlatforms = availablePlatforms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public Set<Platform> getAvailablePlatforms() {
        return availablePlatforms;
    }

    public void setAvailablePlatforms(Set<Platform> availablePlatforms) {
        this.availablePlatforms = availablePlatforms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(gameTitle, game.gameTitle) && Objects.equals(availablePlatforms, game.availablePlatforms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameTitle, availablePlatforms);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameTitle='" + gameTitle + '\'' +
                ", availablePlatforms=" + availablePlatforms +
                '}';
    }
}
