package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class TableInfo extends Table {

    private String friendlyName;
    private Integer availableSeats;

    public TableInfo(UUID restaurantTableId, UUID restaurantId, String friendlyName, Integer availableSeats) {
        super(restaurantTableId, restaurantId);
        this.friendlyName = friendlyName;
        this.availableSeats = availableSeats;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "friendlyName='" + friendlyName + '\'' +
                ", availableSeats='" + availableSeats + '\'' +
                "} " + super.toString();
    }
}
