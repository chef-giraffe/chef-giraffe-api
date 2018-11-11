package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class TableCreate {

    private UUID restaurantId;
    private String friendlyName;
    private Integer availableSeats;

    public TableCreate(UUID restaurantId, String friendlyName, Integer availableSeats) {
        this.restaurantId = restaurantId;
        this.friendlyName = friendlyName;
        this.availableSeats = availableSeats;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public String toString() {
        return "TableCreate{" +
                "restaurantId=" + restaurantId +
                ", friendlyName='" + friendlyName + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
