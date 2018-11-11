package com.chefgiraffe.api.services;

import com.chefgiraffe.api.services.models.*;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<RestaurantInfo> retrieveAll();
    Optional<RestaurantInfo> retrieveOne(RestaurantLookup lookup);
    Optional<RestaurantMenuDetails> retrieveMenuDetails(RestaurantLookup lookup);
    Optional<CreatedRestaurant> create(RestaurantCreate create);
}
