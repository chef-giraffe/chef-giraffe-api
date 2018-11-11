package com.chefgiraffe.api.services.impl;

import com.chefgiraffe.api.repositories.RestaurantRepository;
import com.chefgiraffe.api.repositories.models.Restaurant;
import com.chefgiraffe.api.services.RestaurantService;
import com.chefgiraffe.api.services.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static Logger logger = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<RestaurantInfo> retrieveAll() {

        List<RestaurantInfo> restaurants = new ArrayList<>();

        restaurantRepository.findAll().forEach(restaurant ->
                restaurants.add(new RestaurantInfo(restaurant.getId(),
                                                   restaurant.getName(),
                                                   restaurant.getMenus().size())));

        return restaurants;
    }

    @Override
    public Optional<RestaurantInfo> retrieveOne(RestaurantLookup lookup) {

        Optional<Restaurant> restaurant = restaurantRepository.findById(lookup.getRestaurantId());
        if (restaurant.isPresent()) {

            logger.info("found restaurant {}", restaurant.get().getId().toString());
            return Optional.of(new RestaurantInfo(restaurant.get().getId(),
                                                  restaurant.get().getName(),
                                                  restaurant.get().getMenus().size()));
        } else {
            logger.warn("restaurant {} not found", lookup.getRestaurantId().toString());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RestaurantMenuDetails> retrieveMenuDetails(RestaurantLookup lookup) {

        Optional<Restaurant> restaurant = restaurantRepository.findById(lookup.getRestaurantId());
        if (restaurant.isPresent()) {

            logger.info("restaurant {} was found", lookup.getRestaurantId().toString());

            RestaurantMenuDetails menuDetails =
                    new RestaurantMenuDetails(restaurant.get().getId(),
                                              restaurant.get().getName(),
                                              restaurant.get().getMenus().stream()
                                                      .map(restaurantMenu ->
                                                              new MenuDetails(restaurantMenu.getId(),
                                                                              restaurantMenu.getRestaurantId(),
                                                                              restaurantMenu.getName(),
                                                                              restaurantMenu.getRestaurantMenuItems().stream()
                                                                                .map(restaurantMenuItem ->
                                                                                        new ItemDetails(restaurantMenuItem.getId(),
                                                                                                        restaurantMenuItem.getRestaurantMenuId(),
                                                                                                        restaurantMenuItem.getName(),
                                                                                                        restaurantMenuItem.getDescription(),
                                                                                                        restaurantMenuItem.getPrice(),
                                                                                                        restaurantMenuItem.getImageUri()))
                                                                                .collect(Collectors.toList())))
                                                      .collect(Collectors.toList()));

            return Optional.of(menuDetails);
        } else {
            logger.warn("restaurant {} was not found", lookup.getRestaurantId().toString());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CreatedRequest> createRestaurantRequest(RequestCreate create) {
        return Optional.empty();
    }

    @Override
    public Optional<CreatedRestaurant> createRestaurant(RestaurantCreate create) {

        Restaurant savedRestaurant = restaurantRepository.save(new Restaurant(create.getName(),
                                                                              Timestamp.valueOf(LocalDateTime.now())));

        return Optional.of(new CreatedRestaurant(savedRestaurant.getId(),
                                                 savedRestaurant.getName(),
                                                 savedRestaurant.getCreatedTime().toLocalDateTime()));
    }
}
