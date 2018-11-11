package com.chefgiraffe.api.services;

import com.chefgiraffe.api.services.models.CreatedRestaurant;
import com.chefgiraffe.api.services.models.RestaurantCreate;
import com.chefgiraffe.api.services.models.RestaurantInfo;
import com.chefgiraffe.api.services.models.RestaurantLookup;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<RestaurantInfo> retrieveAll();
    Optional<RestaurantInfo> retrieveOne(RestaurantLookup lookup);
    Optional<CreatedRestaurant> create(RestaurantCreate create);
}
