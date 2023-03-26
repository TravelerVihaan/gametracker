package com.vihaan.gametracker;

public interface ModelElementMapper<T, U> {

    U convertToEntity(T domainObject);
    T convertToDomainObject(U entityObject);
}
