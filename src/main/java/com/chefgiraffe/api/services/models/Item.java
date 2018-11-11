package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class Item {

    private UUID id;
    private UUID restaurantMenuId;

    public Item(UUID id, UUID restaurantMenuId) {
        this.id = id;
        this.restaurantMenuId = restaurantMenuId;
    }

    public UUID getId() {
        return id;
    }

    public UUID getRestaurantMenuId() {
        return restaurantMenuId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", restaurantMenuId=" + restaurantMenuId +
                '}';
    }
}
