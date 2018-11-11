package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class RequestCreate {

    private UUID restaurantTableId;
    private String description;

    public RequestCreate(UUID restaurantTableId, String description) {
        this.restaurantTableId = restaurantTableId;
        this.description = description;
    }

    public UUID getRestaurantTableId() {
        return restaurantTableId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "RequestCreate{" +
                "restaurantTableId=" + restaurantTableId +
                ", description='" + description + '\'' +
                '}';
    }
}
