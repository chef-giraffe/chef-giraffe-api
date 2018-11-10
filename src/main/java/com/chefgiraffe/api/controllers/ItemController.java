package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.repositories.models.MenuItem;
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
    public ResponseEntity<List<MenuItem>> getAllItems() {
        List<MenuItem> menu = Collections.singletonList(new MenuItem(null, null, null, null));
        return new ResponseEntity<List<MenuItem>>(menu, HttpStatus.NOT_IMPLEMENTED);

    }

    @GetMapping("/item/{id}")
    public ResponseEntity<MenuItem> getItem(@PathVariable("id") UUID id) {
        return new ResponseEntity<MenuItem>(new MenuItem(null, null, null, null), HttpStatus.NOT_IMPLEMENTED);
    }
}
