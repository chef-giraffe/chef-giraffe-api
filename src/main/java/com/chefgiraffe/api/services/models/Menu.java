package com.chefgiraffe.api.services.models;

import java.util.UUID;

public class Menu {

    private UUID id;
    private UUID restaurantId;
    private String name;

    public Menu(UUID id, UUID restaurantId, String name) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                '}';
    }
}
