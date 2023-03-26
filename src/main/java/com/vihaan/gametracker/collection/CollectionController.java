package com.vihaan.gametracker.collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("collection")
public class CollectionController {

    private CollectionHandler collectionHandler;

    @Autowired
    public CollectionController(CollectionHandler collectionHandler) {
        this.collectionHandler = collectionHandler;
    }

    @GetMapping(value = {"/{collectionName}", "/{collectionName}/sortType}"}, produces = "application/json")
    public GamesCollection getGamesCollection(@PathVariable String collectionName, @PathVariable(required = false) SortType sortType){
        return collectionHandler.getCollectionByName(collectionName);
    }

}
