package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.repositories.models.RestaurantMenuItem;
import com.chefgiraffe.api.services.RestaurantItemService;
import com.chefgiraffe.api.services.models.ItemLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.server.UID;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ItemController {

    private static Logger logger = LoggerFactory.getLogger(ItemController.class);

    private final RestaurantItemService restaurantItemService;

    @Autowired
    public ItemController(RestaurantItemService restaurantItemService) {
        this.restaurantItemService = restaurantItemService;
    }

    @GetMapping("/items")
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok(restaurantItemService.retrieveAll());
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<?> readOne(@PathVariable("id") UUID id) {

        Optional<RestaurantMenuItem> menuItem = restaurantItemService.retrieve(new ItemLookup(id));
        if (menuItem.isPresent()) {

            logger.info("found item {}", menuItem.get().getId());
            return ResponseEntity.ok(menuItem.get());
        } else {
            logger.warn("no items found for item {}", id);
            return ResponseEntity.notFound().build();
        }
    }
}
