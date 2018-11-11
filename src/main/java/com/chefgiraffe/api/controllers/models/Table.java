package com.chefgiraffe.api.controllers.models;

import java.util.UUID;

public class Table {

    private UUID restaurantId;
    private String friendlyName;
    private Integer availableSeats;

    public Table() {
    }

    public Table(UUID restaurantId, String friendlyName, Integer availableSeats) {
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
        return "Table{" +
                "restaurantId=" + restaurantId +
                ", friendlyName='" + friendlyName + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
