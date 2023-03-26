package com.vihaan.gametracker.game.storage.sql.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "games")
public class GameEntity {

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
    private Set<PlatformEntity> availablePlatformEntities;

    public GameEntity() {}
    public GameEntity(String gameTitle, Set<PlatformEntity> availablePlatformEntities) {
        this.gameTitle = gameTitle;
        this.availablePlatformEntities = availablePlatformEntities;
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

    public Set<PlatformEntity> getAvailablePlatforms() {
        return availablePlatformEntities;
    }

    public void setAvailablePlatforms(Set<PlatformEntity> availablePlatformEntities) {
        this.availablePlatformEntities = availablePlatformEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameEntity gameEntity = (GameEntity) o;
        return Objects.equals(gameTitle, gameEntity.gameTitle) && Objects.equals(availablePlatformEntities, gameEntity.availablePlatformEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameTitle, availablePlatformEntities);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameTitle='" + gameTitle + '\'' +
                ", availablePlatforms=" + availablePlatformEntities +
                '}';
    }
}
