package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class Request {

    private UUID id;
    private UUID restaurantTableId;
    private String description;

    public Request(UUID id, UUID restaurantTableId, String description) {
        this.id = id;
        this.restaurantTableId = restaurantTableId;
        this.description = description;
    }

    public UUID getId() {
        return id;
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
                "id=" + id +
                ", restaurantTableId=" + restaurantTableId +
                ", description='" + description + '\'' +
                '}';
    }
}
