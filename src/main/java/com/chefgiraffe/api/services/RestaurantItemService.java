package com.chefgiraffe.api.services;

import com.chefgiraffe.api.repositories.models.RestaurantMenuItem;
import com.chefgiraffe.api.services.models.ItemLookup;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantItemService {
    Optional<RestaurantMenuItem> create(UUID restaurantMenuId,
                                        String name,
                                        String description,
                                        BigDecimal price,
                                        String imageUri);

    List<RestaurantMenuItem> retrieveAll();
    Optional<RestaurantMenuItem> retrieve(ItemLookup lookup);
    Optional<RestaurantMenuItem> update(RestaurantMenuItem update);
}
