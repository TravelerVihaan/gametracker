package com.vihaan.gametracker.collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("collection")
public class CollectionController {

    private CollectionHandler collectionHandler;

    @Autowired
    public CollectionController(CollectionHandler collectionHandler) {
        this.collectionHandler = collectionHandler;
    }

}
