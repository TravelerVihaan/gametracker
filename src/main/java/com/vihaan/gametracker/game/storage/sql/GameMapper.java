package com.vihaan.gametracker.game.storage.sql;

import com.vihaan.gametracker.ModelElementMapper;
import com.vihaan.gametracker.game.Game;
import com.vihaan.gametracker.game.storage.sql.model.GameEntity;

public class GameMapper implements ModelElementMapper<Game, GameEntity> {
    @Override
    public GameEntity convertToEntity(Game domainObject) {
        return null;
    }

    @Override
    public Game convertToDomainObject(GameEntity domainObject) {
        return null;
    }
}
