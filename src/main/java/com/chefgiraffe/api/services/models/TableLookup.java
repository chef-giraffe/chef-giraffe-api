package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class TableLookup {

    private UUID restaurantTableId;

    public TableLookup(UUID restaurantTableId) {
        this.restaurantTableId = restaurantTableId;
    }

    public UUID getRestaurantTableId() {
        return restaurantTableId;
    }

    @Override
    public String toString() {
        return "TableLookup{" +
                "restaurantTableId=" + restaurantTableId +
                '}';
    }
}
