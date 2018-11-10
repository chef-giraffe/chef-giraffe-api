package com.chefgiraffe.api.services;

import com.chefgiraffe.api.services.models.CreatedTable;

import java.util.Optional;

public interface RestaurantTableService {

    Optional<CreatedTable> create();
}
