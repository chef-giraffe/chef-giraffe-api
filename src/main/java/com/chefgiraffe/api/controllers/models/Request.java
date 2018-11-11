package com.chefgiraffe.api.controllers.models;

import java.util.UUID;

public class Request {

    private UUID restaurantTableId;
    private String description;

    public Request() {
    }

    public Request(UUID restaurantTableId, String description) {
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
        return "Request{" +
                "restaurantTableId=" + restaurantTableId +
                ", description='" + description + '\'' +
                '}';
    }
}
