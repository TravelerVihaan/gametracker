package com.vihaan.gametracker.game.storage.sql;

import com.vihaan.gametracker.ModelElementMapper;
import com.vihaan.gametracker.game.Game;
import com.vihaan.gametracker.game.Platform;
import com.vihaan.gametracker.game.storage.sql.model.GameEntity;
import com.vihaan.gametracker.game.storage.sql.model.PlatformEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("game_mapper")
public class GameMapper implements ModelElementMapper<Game, GameEntity> {

    private ModelElementMapper<Platform, PlatformEntity> platformMapper;

    @Autowired
    public GameMapper(ModelElementMapper<Platform, PlatformEntity> platformMapper) {
        this.platformMapper = platformMapper;
    }

    @Override
    public GameEntity convertToEntity(Game domainObject) {
        return new GameEntity(domainObject.title(),
                domainObject.platforms().stream().map(platformMapper::convertToEntity).collect(Collectors.toSet()));
    }

    @Override
    public Game convertToDomainObject(GameEntity entityObject) {
        return new Game(entityObject.getGameTitle(),
                entityObject.getAvailablePlatforms().stream().map(platformMapper::convertToDomainObject).collect(Collectors.toSet()));
    }
}
