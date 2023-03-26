package com.vihaan.gametracker.game.storage.sql;

import com.vihaan.gametracker.ModelElementMapper;
import com.vihaan.gametracker.game.Platform;
import com.vihaan.gametracker.game.storage.sql.model.PlatformEntity;

public class PlatformMapper implements ModelElementMapper<Platform, PlatformEntity> {
    @Override
    public PlatformEntity convertToEntity(Platform domainObject) {
        return null;
    }

    @Override
    public Platform convertToDomainObject(PlatformEntity domainObject) {
        return null;
    }
}
