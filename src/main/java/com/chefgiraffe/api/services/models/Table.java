package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class Table {

    private UUID restaurantTableId;
    private UUID restaurantId;

    public Table(UUID restaurantTableId, UUID restaurantId) {
        this.restaurantTableId = restaurantTableId;
        this.restaurantId = restaurantId;
    }

    public UUID getRestaurantTableId() {
        return restaurantTableId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }
}
