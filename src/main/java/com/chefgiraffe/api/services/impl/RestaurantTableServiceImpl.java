package com.chefgiraffe.api.services.impl;

import com.chefgiraffe.api.repositories.RestaurantRepository;
import com.chefgiraffe.api.repositories.RestaurantTableRepository;
import com.chefgiraffe.api.repositories.models.Restaurant;
import com.chefgiraffe.api.repositories.models.RestaurantTable;
import com.chefgiraffe.api.services.RestaurantTableService;
import com.chefgiraffe.api.services.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {

    private static Logger logger = LoggerFactory.getLogger(RestaurantTableServiceImpl.class);

    private final RestaurantRepository restaurantRepository;
    private final RestaurantTableRepository restaurantTableRepository;

    @Autowired
    public RestaurantTableServiceImpl(RestaurantRepository restaurantRepository,
                                      RestaurantTableRepository restaurantTableRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantTableRepository = restaurantTableRepository;
    }

    @Override
    public List<TableInfo> retrieveAll() {
        List<TableInfo> tables = new ArrayList<>();

        restaurantTableRepository.findAll().forEach(restaurantTable ->
                tables.add(new TableInfo(restaurantTable.getId(),
                                         restaurantTable.getRestaurantId(),
                                         restaurantTable.getFriendlyName(),
                                         restaurantTable.getAvailableSeats())));

        return tables;
    }

    @Override
    public Optional<TableOrderDetails> retrieveAllOrders(TableLookup lookup) {

        Optional<RestaurantTable> table = restaurantTableRepository.findById(lookup.getRestaurantTableId());
        if (table.isPresent()) {

            List<OrderDetails> orderDetails = table.get().getRestaurantOrders().stream()
                    .map(restaurantOrder ->
                            new OrderDetails(restaurantOrder.getId(),
                                    restaurantOrder.getRestaurantTableId(),
                                    restaurantOrder.getRestaurantMenuItems().stream()
                                            .map(restaurantMenuItem ->
                                                    new ItemDetails(restaurantMenuItem.getId(),
                                                            restaurantMenuItem.getRestaurantMenuId(),
                                                            restaurantMenuItem.getName(),
                                                            restaurantMenuItem.getDescription(),
                                                            restaurantMenuItem.getPrice(),
                                                            restaurantMenuItem.getImageUri()))
                                            .collect(Collectors.toList())))
                    .collect(Collectors.toList());

            return Optional.of(new TableOrderDetails(table.get().getId(),
                                                     table.get().getRestaurantId(),
                                                     table.get().getFriendlyName(),
                                                     table.get().getAvailableSeats(),
                                                     orderDetails));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<TableOrderDetails> retrieveSpecificOrders(TableLookup lookup) {

        Optional<RestaurantTable> table = restaurantTableRepository.findById(lookup.getRestaurantTableId());
        if (table.isPresent()) {

            String orderStatusFilter = lookup.getOrderStatus().toString();
            List<OrderDetails> orderDetails = table.get().getRestaurantOrders().stream()
                    .filter(restaurantOrder ->
                            restaurantOrder.getOrderStatus().equals(orderStatusFilter))
                    .map(restaurantOrder ->
                            new OrderDetails(restaurantOrder.getId(),
                                    restaurantOrder.getRestaurantTableId(),
                                    restaurantOrder.getRestaurantMenuItems().stream()
                                            .map(restaurantMenuItem ->
                                                    new ItemDetails(restaurantMenuItem.getId(),
                                                            restaurantMenuItem.getRestaurantMenuId(),
                                                            restaurantMenuItem.getName(),
                                                            restaurantMenuItem.getDescription(),
                                                            restaurantMenuItem.getPrice(),
                                                            restaurantMenuItem.getImageUri()))
                                            .collect(Collectors.toList())))
                    .collect(Collectors.toList());

            return Optional.of(new TableOrderDetails(table.get().getId(),
                                                     table.get().getRestaurantId(),
                                                     table.get().getFriendlyName(),
                                                     table.get().getAvailableSeats(),
                                                     orderDetails));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<TableInfo> retrieve(TableLookup lookup) {

        Optional<RestaurantTable> table = restaurantTableRepository.findById(lookup.getRestaurantTableId());
        if (table.isPresent()) {

            logger.info("found table {}", table.get().getId().toString());
            return Optional.of(new TableInfo(table.get().getId(),
                                             table.get().getRestaurantId(),
                                             table.get().getFriendlyName(),
                                             table.get().getAvailableSeats()));
        } else {
            logger.warn("table {} was not found", lookup.getRestaurantTableId());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CreatedTable> create(TableCreate create) {

        Optional<Restaurant> restaurant = restaurantRepository.findById(create.getRestaurantId());
        if (restaurant.isPresent()) {

            logger.debug("creating new table for restaurant {}", restaurant.get().getId().toString());
            RestaurantTable newTable =
                    restaurantTableRepository.save(new RestaurantTable(restaurant.get().getId(),
                                                                       create.getFriendlyName(),
                                                                       create.getAvailableSeats()));

            logger.info("created new table {} for restaurant {}", newTable.getId().toString(),
                    newTable.getRestaurantId().toString());
            return Optional.of(new CreatedTable(newTable.getId(), newTable.getRestaurantId()));
        } else {
            logger.warn("tried to create a table for unknown restaurant {}", create.getRestaurantId().toString());
            return Optional.empty();
        }
    }
}
