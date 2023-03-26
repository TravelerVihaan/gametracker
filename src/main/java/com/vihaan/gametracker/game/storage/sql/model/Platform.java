package com.vihaan.gametracker.game.storage.sql.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "platforms")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_platform")
    private Long id;

    @Column(name = "platform_name", nullable = false, unique = true)
    private String platformName;

    @ManyToMany(mappedBy = "availablePlatforms")
    private Set<Game> games;

    public Platform() {}
    public Platform(Long id, String platformName) {
        this.id = id;
        this.platformName = platformName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Platform platform = (Platform) o;
        return Objects.equals(platformName, platform.platformName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platformName);
    }

    @Override
    public String toString() {
        return "Platform{" +
                "id=" + id +
                ", platformName='" + platformName + '\'' +
                '}';
    }
}
