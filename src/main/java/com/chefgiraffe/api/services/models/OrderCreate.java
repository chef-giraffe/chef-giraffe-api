package com.chefgiraffe.api.services.models;

import java.util.List;
import java.util.UUID;

public class OrderCreate {

    private UUID restaurantTableId;
    private List<UUID> restaurantMenuItemIds;

    public OrderCreate(UUID restaurantTableId, List<UUID> restaurantMenuItemIds) {
        this.restaurantTableId = restaurantTableId;
        this.restaurantMenuItemIds = restaurantMenuItemIds;
    }

    public UUID getRestaurantTableId() {
        return restaurantTableId;
    }

    public List<UUID> getRestaurantMenuItemIds() {
        return restaurantMenuItemIds;
    }

    @Override
    public String toString() {
        return "OrderCreate{" +
                "restaurantTableId=" + restaurantTableId +
                ", restaurantMenuItemIds=" + restaurantMenuItemIds +
                '}';
    }
}
