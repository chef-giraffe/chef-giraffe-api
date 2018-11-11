package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.controllers.models.Request;
import com.chefgiraffe.api.controllers.models.Restaurant;
import com.chefgiraffe.api.services.RestaurantService;
import com.chefgiraffe.api.services.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

@RestController
public class RestaurantController {

    private static Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    private final RestaurantService restaurantService;
    private final String baseUrl;

    @Autowired
    public RestaurantController(RestaurantService restaurantService, @Value("${base_url}") String baseUrl) {
        this.restaurantService = restaurantService;
        this.baseUrl = baseUrl;
    }

    @GetMapping("/restaurants")
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok(restaurantService.retrieveAll());
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<?> readOne(@PathVariable("id") UUID id) {

        Optional<RestaurantInfo> restaurant = restaurantService.retrieveOne(new RestaurantLookup(id));
        if (restaurant.isPresent()) {

            logger.info("restaurant {} was found", restaurant.get().getId().toString());
            return ResponseEntity.ok(restaurant.get());
        } else {
            logger.warn("restaurant {} was not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/restaurants/{id}/menus")
    public ResponseEntity<?> readRestaurantMenus(@PathVariable("id") UUID id) {

        Optional<RestaurantMenuDetails> menuDetails = restaurantService.retrieveMenuDetails(new RestaurantLookup(id));
        if (menuDetails.isPresent()) {

            logger.info("menu {} was found", menuDetails.get().getId());
            return ResponseEntity.ok(menuDetails.get());
        } else {
            logger.warn("menu {} was not found", id.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/restaurants/{id}/requests")
    public ResponseEntity<?> createRestaurantRequest(@PathVariable("id") String id, @RequestBody Request request) {
        Optional<CreatedRequest> createdRequest =
                restaurantService.createRestaurantRequest(new RequestCreate(request.getRestaurantTableId(),
                                                                            request.getDescription()));
        if (createdRequest.isPresent()) {

            UriComponents uriComponents = UriComponentsBuilder.fromUriString(baseUrl)
                    .pathSegment("restaurants", "{id}", "requests", "{requestId}")
                    .buildAndExpand(id, createdRequest.get().getId().toString());

            return ResponseEntity.created(uriComponents.toUri()).build();
        } else {
            logger.warn("could not createRestaurant request for table {}", request.getRestaurantTableId().toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/restaurants/{id}/requests/{requestId}")
    public ResponseEntity<?> readOneRestaurantRequest(@PathVariable("id") String id,
                                                      @PathVariable("requestId") String requestId) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@RequestBody Restaurant restaurant) {

        Optional<CreatedRestaurant> createdRestaurant =
                restaurantService.createRestaurant(new RestaurantCreate(restaurant.getName()));
        if (createdRestaurant.isPresent()) {

            UriComponents uriComponentsBuilder = UriComponentsBuilder.fromUriString(baseUrl)
                    .pathSegment("restaurants", "{id}")
                    .buildAndExpand(createdRestaurant.get().getId().toString());

            return ResponseEntity.created(uriComponentsBuilder.toUri()).build();
        } else {
            logger.warn("restaurant was not created for {}", restaurant.getName());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
