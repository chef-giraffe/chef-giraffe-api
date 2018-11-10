package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.repositories.models.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Controller
public class ItemController {
    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> menu = Collections.singletonList(new Item(null, null, null, null));
        return new ResponseEntity<List<Item>>(menu, HttpStatus.NOT_IMPLEMENTED);

    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItem(@PathVariable("id") UUID id) {
        return new ResponseEntity<Item>(new Item(null, null, null, null), HttpStatus.NOT_IMPLEMENTED);
    }
}
