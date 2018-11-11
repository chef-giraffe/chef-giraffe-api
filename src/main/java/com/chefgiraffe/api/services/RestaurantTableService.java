package com.chefgiraffe.api.services;

import com.chefgiraffe.api.services.models.CreatedTable;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantTableService {

    Optional<CreatedTable> create(UUID restaurantId, String friendlyName, Integer availableSeats);
}
