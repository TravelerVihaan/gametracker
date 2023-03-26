package com.vihaan.gametracker.collection.storage.sql.model;

import com.vihaan.gametracker.game.storage.sql.model.Game;
import com.vihaan.gametracker.game.storage.sql.model.Platform;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "games_collection_element")
public class GameCollectionElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game_collection_element")
    private Long id;

    @Column(name = "completed_status")
    private boolean completed;
    @ManyToOne
    @JoinColumn(name="game_id", nullable=false)
    private Game game;

    @ManyToOne
    @JoinColumn(name="platform_id", nullable=false)
    private Platform platform;

    @ManyToOne
    @JoinColumn(name="games_collection_id", nullable=false)
    private GamesCollection gamesCollection;


    public GameCollectionElement() {}

    public GameCollectionElement(Long id, boolean completed, Game game, Platform platform, GamesCollection gamesCollection) {
        this.id = id;
        this.completed = completed;
        this.game = game;
        this.platform = platform;
        this.gamesCollection = gamesCollection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public GamesCollection getGamesCollection() {
        return gamesCollection;
    }

    public void setGamesCollection(GamesCollection gamesCollection) {
        this.gamesCollection = gamesCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCollectionElement that = (GameCollectionElement) o;
        return Objects.equals(game.getGameTitle(), that.game.getGameTitle()) && Objects.equals(platform.getPlatformName(), that.platform.getPlatformName()) && Objects.equals(gamesCollection.getCollectionName(), that.gamesCollection.getCollectionName()) && Objects.equals(completed, that.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game.getGameTitle(), platform.getPlatformName(), gamesCollection.getCollectionName(), completed);
    }

    @Override
    public String toString() {
        return "GameCollectionElement{" +
                "id=" + id +
                ", completed=" + completed +
                ", game=" + game +
                ", platform=" + platform +
                ", gamesCollection=" + gamesCollection +
                '}';
    }
}
