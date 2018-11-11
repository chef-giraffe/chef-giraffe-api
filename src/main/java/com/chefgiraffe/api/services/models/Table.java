package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class Table {

    private UUID id;
    private UUID restaurantId;

    public Table(UUID id, UUID restaurantId) {
        this.id = id;
        this.restaurantId = restaurantId;
    }

    public UUID getId() {
        return id;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }
}
