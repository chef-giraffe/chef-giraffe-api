package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class Item {

    private UUID itemId;
    private UUID restaurantMenuId;

    public Item(UUID itemId, UUID restaurantMenuId) {
        this.itemId = itemId;
        this.restaurantMenuId = restaurantMenuId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public UUID getRestaurantMenuId() {
        return restaurantMenuId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", restaurantMenuId=" + restaurantMenuId +
                '}';
    }
}
