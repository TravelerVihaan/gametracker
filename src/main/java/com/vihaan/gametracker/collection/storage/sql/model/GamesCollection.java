package com.vihaan.gametracker.collection.storage.sql.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "games_collections")
public class GamesCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_games_collection")
    private Long id;

    @Column(name = "collection_name", nullable = false, unique = true)
    private String collectionName;

    @OneToMany(mappedBy = "gamesCollection")
    private List<GameCollectionElement> games;

    public GamesCollection() {}
    public GamesCollection(Long id, String collectionName, List<GameCollectionElement> games) {
        this.id = id;
        this.collectionName = collectionName;
        this.games = games;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public List<GameCollectionElement> getGames() {
        return games;
    }

    public void setGames(List<GameCollectionElement> games) {
        this.games = games;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamesCollection that = (GamesCollection) o;
        return Objects.equals(collectionName, that.collectionName) && Objects.equals(games, that.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectionName, games);
    }

    @Override
    public String toString() {
        return "GamesCollection{" +
                "id=" + id +
                ", collectionName='" + collectionName + '\'' +
                ", games=" + games +
                '}';
    }
}
