package com.vihaan.gametracker.collection.storage.sql;

import com.vihaan.gametracker.ModelElementMapper;
import com.vihaan.gametracker.collection.GameCollectionElement;
import com.vihaan.gametracker.collection.GamesCollection;
import com.vihaan.gametracker.collection.storage.sql.model.GameCollectionElementEntity;
import com.vihaan.gametracker.collection.storage.sql.model.GamesCollectionEntity;
import com.vihaan.gametracker.game.Game;
import com.vihaan.gametracker.game.Platform;
import com.vihaan.gametracker.game.storage.sql.model.GameEntity;
import com.vihaan.gametracker.game.storage.sql.model.PlatformEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("game_collection_element_mapper")
public class GameCollectionElementMapper implements ModelElementMapper<GameCollectionElement, GameCollectionElementEntity> {

    private ModelElementMapper<Game, GameEntity> gameMapper;
    private ModelElementMapper<Platform, PlatformEntity> platformMapper;
    private ModelElementMapper<GamesCollection, GamesCollectionEntity> gamesCollectionMapper;

    @Autowired
    public GameCollectionElementMapper(@Qualifier("game_mapper") ModelElementMapper<Game, GameEntity> gameMapper,
                                       @Qualifier("platform_mapper") ModelElementMapper<Platform, PlatformEntity> platformMapper,
                                       @Qualifier("games_collection_mapper") ModelElementMapper<GamesCollection, GamesCollectionEntity> gamesCollectionMapper) {
        this.gameMapper = gameMapper;
        this.platformMapper = platformMapper;
        this.gamesCollectionMapper = gamesCollectionMapper;
    }

    @Override
    public GameCollectionElementEntity convertToEntity(GameCollectionElement domainObject) {
        GameEntity gameEntity = gameMapper.convertToEntity(domainObject.game());
        PlatformEntity platformEntity = platformMapper.convertToEntity(domainObject.platform());
        return new GameCollectionElementEntity(domainObject.completionStatus(), gameEntity, platformEntity);
    }

    @Override
    public GameCollectionElement convertToDomainObject(GameCollectionElementEntity entityObject) {
        Game game = gameMapper.convertToDomainObject(entityObject.getGame());
        return new GameCollectionElement(game, Platform.valueOf(entityObject.getPlatform().getPlatformName()), entityObject.isCompleted());
    }
}
