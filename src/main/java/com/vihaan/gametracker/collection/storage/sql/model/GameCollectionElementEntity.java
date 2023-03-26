package com.vihaan.gametracker.collection.storage.sql.model;

import com.vihaan.gametracker.game.storage.sql.model.GameEntity;
import com.vihaan.gametracker.game.storage.sql.model.PlatformEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "games_collection_element")
public class GameCollectionElementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game_collection_element")
    private Long id;

    @Column(name = "completed_status")
    private boolean completed;
    @ManyToOne
    @JoinColumn(name="game_id", nullable=false)
    private GameEntity gameEntity;

    @ManyToOne
    @JoinColumn(name="platform_id", nullable=false)
    private PlatformEntity platformEntity;

    @ManyToOne
    @JoinColumn(name="games_collection_id", nullable=false)
    private GamesCollectionEntity gamesCollectionEntity;


    public GameCollectionElementEntity() {}

    public GameCollectionElementEntity(boolean completed, GameEntity gameEntity, PlatformEntity platformEntity) {
        this.completed = completed;
        this.gameEntity = gameEntity;
        this.platformEntity = platformEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameEntity getGame() {
        return gameEntity;
    }

    public void setGame(GameEntity gameEntity) {
        this.gameEntity = gameEntity;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public PlatformEntity getPlatform() {
        return platformEntity;
    }

    public void setPlatform(PlatformEntity platformEntity) {
        this.platformEntity = platformEntity;
    }

    public GamesCollectionEntity getGamesCollection() {
        return gamesCollectionEntity;
    }

    public void setGamesCollection(GamesCollectionEntity gamesCollectionEntity) {
        this.gamesCollectionEntity = gamesCollectionEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCollectionElementEntity that = (GameCollectionElementEntity) o;
        return Objects.equals(gameEntity.getGameTitle(), that.gameEntity.getGameTitle()) && Objects.equals(platformEntity.getPlatformName(), that.platformEntity.getPlatformName()) && Objects.equals(gamesCollectionEntity.getCollectionName(), that.gamesCollectionEntity.getCollectionName()) && Objects.equals(completed, that.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameEntity.getGameTitle(), platformEntity.getPlatformName(), gamesCollectionEntity.getCollectionName(), completed);
    }

    @Override
    public String toString() {
        return "GameCollectionElement{" +
                "id=" + id +
                ", completed=" + completed +
                ", game=" + gameEntity +
                ", platform=" + platformEntity +
                ", gamesCollection=" + gamesCollectionEntity +
                '}';
    }
}
