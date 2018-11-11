package com.chefgiraffe.api.services.impl;

import com.chefgiraffe.api.repositories.RestaurantRepository;
import com.chefgiraffe.api.repositories.RestaurantTableRepository;
import com.chefgiraffe.api.repositories.models.Restaurant;
import com.chefgiraffe.api.repositories.models.RestaurantTable;
import com.chefgiraffe.api.services.RestaurantTableService;
import com.chefgiraffe.api.services.models.CreatedTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {

    private static Logger logger = LoggerFactory.getLogger(RestaurantTableServiceImpl.class);

    private final RestaurantRepository restaurantRepository;
    private final RestaurantTableRepository restaurantTableRepository;

    @Autowired
    public RestaurantTableServiceImpl(RestaurantRepository restaurantRepository, RestaurantTableRepository restaurantTableRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantTableRepository = restaurantTableRepository;
    }

    @Override
    public Optional<CreatedTable> create(UUID restaurantId, String friendlyName, Integer availableSeats) {

        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

        if (restaurant.isPresent()) {

            logger.debug("creating new table for restaurant {}", restaurantId.toString());
            RestaurantTable newTable =
                    restaurantTableRepository.save(new RestaurantTable(restaurantId, friendlyName, availableSeats));

            logger.info("created new table {} for restaurant {}", newTable.getId().toString(),
                    newTable.getRestaurantId().toString());
            return Optional.of(new CreatedTable(newTable.getId(), newTable.getRestaurantId()));
        } else {
            logger.warn("tried to create a table for unknown restaurant {}", restaurantId.toString());
            return Optional.empty();
        }
    }
}
