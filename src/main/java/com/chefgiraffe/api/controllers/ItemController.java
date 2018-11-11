package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.repositories.models.RestaurantMenuItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class ItemController {
    @GetMapping("/items")
    public ResponseEntity<List<RestaurantMenuItem>> getAllItems() {
        List<RestaurantMenuItem> menu = Collections.singletonList(new RestaurantMenuItem(null,null, null, null, null));
        return new ResponseEntity<List<RestaurantMenuItem>>(menu, HttpStatus.NOT_IMPLEMENTED);

    }

    @GetMapping("/item/{id}")
    public ResponseEntity<RestaurantMenuItem> getItem(@PathVariable("id") UUID id) {
        return new ResponseEntity<RestaurantMenuItem>(new RestaurantMenuItem(null,null, null, null, null), HttpStatus.NOT_IMPLEMENTED);
    }
}
