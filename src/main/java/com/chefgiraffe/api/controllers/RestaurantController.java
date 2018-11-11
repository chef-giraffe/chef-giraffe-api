package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.services.RestaurantService;
import com.chefgiraffe.api.services.models.RestaurantInfo;
import com.chefgiraffe.api.services.models.RestaurantLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class RestaurantController {

    private static Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok(restaurantService.retrieveAll());
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<?> readOne(@PathVariable("id") String id) {

        Optional<RestaurantInfo> restaurant = restaurantService.retrieveOne(new RestaurantLookup(UUID.fromString(id)));
        if (restaurant.isPresent()) {

            logger.info("restaurant {} was found", restaurant.get().getId().toString());
            return ResponseEntity.ok(restaurant.get());
        } else {
            logger.warn("restaurant {} was not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}
