package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.services.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    private static Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

//    @GetMapping("/restaurants")
//    public ResponseEntity<?> readAll() {
//
//    }
//
//    @GetMapping("/restaurants/{id}")
//    public ResponseEntity<?> readOne(@PathVariable("id") String id) {
//
//    }
}
