package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class RestaurantLookup {

    private UUID restaurantId;

    public RestaurantLookup(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    @Override
    public String toString() {
        return "RestaurantLookup{" +
                "restaurantId=" + restaurantId +
                '}';
    }
}
