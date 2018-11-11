package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class Table {

    private UUID tableId;
    private UUID restaurantId;

    public Table(UUID tableId, UUID restaurantId) {
        this.tableId = tableId;
        this.restaurantId = restaurantId;
    }

    public UUID getTableId() {
        return tableId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }
}
