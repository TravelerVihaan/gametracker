package com.vihaan.gametracker.game.storage.sql;

import com.vihaan.gametracker.ModelElementMapper;
import com.vihaan.gametracker.game.Platform;
import com.vihaan.gametracker.game.storage.sql.model.PlatformEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("platform_mapper")
public class PlatformMapper implements ModelElementMapper<Platform, PlatformEntity> {
    @Override
    public PlatformEntity convertToEntity(Platform domainObject) {
        return new PlatformEntity(domainObject.name(), Collections.emptySet());
    }

    @Override
    public Platform convertToDomainObject(PlatformEntity entityObject) {
        return Platform.valueOf(entityObject.getPlatformName());
    }
}
