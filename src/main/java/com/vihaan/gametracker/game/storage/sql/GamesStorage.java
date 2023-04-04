package com.vihaan.gametracker.game.storage.sql;

import org.springframework.stereotype.Service;

@Service
public class GamesStorage {

    private final GameRepository gameRepository;
    private final PlatformRepository platformRepository;

    public GamesStorage(GameRepository gameRepository, PlatformRepository platformRepository) {
        this.gameRepository = gameRepository;
        this.platformRepository = platformRepository;
    }
}
